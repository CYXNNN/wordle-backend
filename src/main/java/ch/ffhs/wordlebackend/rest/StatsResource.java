package ch.ffhs.wordlebackend.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import ch.ffhs.wordlebackend.dto.StatsDto;
import ch.ffhs.wordlebackend.dto.StatsPutDto;
import ch.ffhs.wordlebackend.model.Stats;
import ch.ffhs.wordlebackend.repo.StatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/wordle/stats")
public class StatsResource {

	@Autowired
	private StatsRepo repo;

	@PutMapping("/")
	public @ResponseBody HttpStatus push(@Valid @RequestBody StatsPutDto dto) {

		var userStats = repo.findById(dto.identifier).orElse(new Stats());

		userStats.setIdentifier(dto.identifier);

		var games = userStats.getGames() + 1;
		userStats.setGames(games);
		userStats.increment(dto.numberOfTries);

		repo.save(userStats);

		return HttpStatus.OK;
	}

	@GetMapping("/{identifier}")
	public @ResponseBody StatsDto get(@PathVariable("identifier") String identifier) {
		var entity = repo.findById(identifier)
				.orElseThrow(() -> new NullPointerException("user not found"));

		return StatsDto.fromEntity(entity);

	}

	@GetMapping("/")
	public @ResponseBody
	List<StatsDto> getAll() {
		return StreamSupport.stream(repo.findAll().spliterator(), false)
				.map(StatsDto::fromEntity)
				.collect(Collectors.toList());

	}
}
