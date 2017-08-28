package me.moriya.domain.addition;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class UppercaseLetters extends Addition {

	private static final long serialVersionUID = -478994676232586097L;

	private UppercaseLetters(Password password) {
        super(password);
    }

    public static UppercaseLetters of(Password password) {
        return new UppercaseLetters(password);
    }

    @Override
    protected Score calculateScore() {
        final String upper = filterOnlyUpperCases(password.getValue());
        if (upper.length() > 0) {
            return Score.of((password.getLength() - upper.length()) * 2);
        }
        return Score.ZERO;
    }

    public static String filterOnlyUpperCases(String value) {
        return value.replaceAll("[^A-Z]", "");
    }

}
