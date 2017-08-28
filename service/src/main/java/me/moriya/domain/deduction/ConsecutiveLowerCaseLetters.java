package me.moriya.domain.deduction;

import java.util.stream.Stream;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class ConsecutiveLowerCaseLetters extends Deduction {

	private static final long serialVersionUID = 7755307156469821339L;

	private ConsecutiveLowerCaseLetters(Password password) {
        super(password);
    }

    public static ConsecutiveLowerCaseLetters of(Password password) {
        return new ConsecutiveLowerCaseLetters(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Stream.of(password.getValue().replaceAll("[^a-z]", ";").split(";"))
                    .filter(s -> s.length() > 1)
                    .map(s -> s.length() - 1)
                    .map(n -> Score.of(n * 2))
                    .reduce(Score.ZERO, Score::sum);
        }
        return Score.ZERO;
    }

}
