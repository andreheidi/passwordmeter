package me.moriya.domain.deduction;

import java.util.stream.Stream;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class ConsecutiveUpperCaseLetters extends Deduction {

	private static final long serialVersionUID = 7586572563649829052L;

	private ConsecutiveUpperCaseLetters(Password password) {
        super(password);
    }

    public static ConsecutiveUpperCaseLetters of(Password password) {
        return new ConsecutiveUpperCaseLetters(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Stream.of(password.getValue().replaceAll("[^A-Z]", ";").split(";"))
                    .filter(s -> s.length() > 1)
                    .map(s -> s.length() - 1)
                    .map(n -> Score.of(n * 2))
                    .reduce(Score.ZERO, Score::sum);
        }
        return Score.ZERO;
    }

}
