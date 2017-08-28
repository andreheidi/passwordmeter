package me.moriya.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Score implements Serializable {

	private static final long serialVersionUID = -7813327415085810535L;
	
	public static Score ZERO = Score.of(0);
	
	private Integer value = Integer.valueOf(0);

	private Score(Integer value) {
		this.value = value;
	}

	public static Score of(Integer value) {
		checkNotNull(value, "value não pode ser null");
		return new Score(value);
	}

	public Score sum(Score score) {
		checkNotNull(score, "score não pode ser null");
		return Score.of(value + score.value);
	}

	public Score negative() {
		if (value > 0) {
			return Score.of(value * -1);
		}
		return this;
	}

}