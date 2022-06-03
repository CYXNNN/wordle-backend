package ch.ffhs.wordlebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Stats {

	@Id
	@Column(length = 100)
	private String identifier;

	@Column
	private Integer games = 0;

	@Column
	private Integer firstTry = 0;

	@Column
	private Integer secondTry = 0;

	@Column
	private Integer thirdTry = 0;

	@Column
	private Integer fourthTry = 0;

	@Column
	private Integer fifthTry = 0;

	@Column
	private Integer sixthTry = 0;

	public void increment(Integer numberOfTries) {

		this.games = this.games + 1;

		switch (numberOfTries) {
			case 6: this.sixthTry = this.sixthTry + 1; break;
			case 5: this.fifthTry = this.fifthTry + 1; break;
			case 4: this.fourthTry = this.fourthTry + 1; break;
			case 3: this.thirdTry = this.thirdTry + 1; break;
			case 2: this.secondTry = this.secondTry + 1; break;
			case 1: this.firstTry = this.firstTry + 1; break;
			default: break;
		}
	}
}
