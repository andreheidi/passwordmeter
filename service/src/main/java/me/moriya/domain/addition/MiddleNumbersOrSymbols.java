package me.moriya.domain.addition;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class MiddleNumbersOrSymbols extends Addition {

	private static final long serialVersionUID = 7658977918812015745L;

	private MiddleNumbersOrSymbols(Password password) {
        super(password);
    }

    public static MiddleNumbersOrSymbols of(Password password) {
        return new MiddleNumbersOrSymbols(password);
    }

    @Override
    protected Score calculateScore() {
        if (password.getLength() > 2) {
            String middle = password.getValue().substring(1, password.getLength() - 1);
            String simbolsOrNumbers = middle.replaceAll("[^\\W\\d]", "");
            return Score.of((simbolsOrNumbers.length()) * 2);
        }
        return Score.ZERO;
    }

}
