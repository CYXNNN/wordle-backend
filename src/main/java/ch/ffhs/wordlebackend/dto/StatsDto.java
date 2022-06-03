package ch.ffhs.wordlebackend.dto;

import ch.ffhs.wordlebackend.model.Stats;

public class StatsDto {

	public String identifier;

	public Integer games;

	public Integer firstTry;

	public Integer secondTry;

	public Integer thirdTry;

	public Integer fourthTry;

	public Integer fifthTry;

	public Integer sixthTry;

	public static StatsDto fromEntity(Stats entity) {
		StatsDto dto = new StatsDto();
		dto.identifier = entity.getIdentifier();
		dto.games = entity.getGames();
		dto.firstTry = entity.getFirstTry();
		dto.secondTry = entity.getSecondTry();
		dto.thirdTry = entity.getThirdTry();
		dto.fourthTry = entity.getFourthTry();
		dto.fifthTry = entity.getFifthTry();
		dto.sixthTry = entity.getSixthTry();

		return dto;
	}
}
