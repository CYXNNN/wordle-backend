package ch.ffhs.wordlebackend.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

public class StatsPutDto {

	@NotNull
	public String identifier;

	@NotNull
	@Min(1)
	@Max(6)
	public Integer numberOfTries;


}
