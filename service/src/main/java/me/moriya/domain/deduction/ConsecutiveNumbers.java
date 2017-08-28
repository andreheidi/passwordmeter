package me.moriya.domain.deduction;

import java.util.stream.Stream;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class ConsecutiveNumbers extends Deduction {

	private static final long serialVersionUID = 4767634401767739928L;

	private ConsecutiveNumbers(Password password) {
        super(password);
    }

    public static ConsecutiveNumbers of(Password password) {
        return new ConsecutiveNumbers(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Stream.of(password.getValue().replaceAll("[^\\d]", ";").split(";"))
                    .filter(s -> s.length() > 1)
                    .map(s -> s.length() - 1)
                    .map(n -> Score.of(n * 2))
                    .reduce(Score.ZERO, Score::sum);
        }
        return Score.ZERO;
    }

}
