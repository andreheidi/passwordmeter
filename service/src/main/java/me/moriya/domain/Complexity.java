package me.moriya.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Range;

import me.moriya.domain.serializer.ComplexitySerializer;

import java.util.stream.Stream;

@JsonSerialize(using = ComplexitySerializer.class)
public enum Complexity {

	VERY_WEAK(Range.lessThan(20)),
	WEAK(Range.closedOpen(20, 40)),
	GOOD(Range.closedOpen(40, 60)),
	STRONG(Range.closedOpen(60, 80)),
	VERY_STRONG(Range.greaterThan(79));

	private final Range<Integer> range;

	Complexity(Range<Integer> range) {
		this.range = range;
	}

	public static Complexity of(Score score) {
		return Stream.of(values())
				.filter(c -> c.range.contains(score.getValue()))
				.findFirst()
				.orElse(VERY_WEAK);
	}

	public Range<Integer> getRange() {
		return range;
	}

	@Override
	public String toString() {
		return name();
	}

}
