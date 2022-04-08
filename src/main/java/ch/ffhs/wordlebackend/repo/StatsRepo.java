package ch.ffhs.wordlebackend.repo;

import ch.ffhs.wordlebackend.model.Stats;
import org.springframework.data.repository.CrudRepository;

public interface StatsRepo extends CrudRepository<Stats, String> {
}
