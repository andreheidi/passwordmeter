package me.moriya.domain.addition;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class LowercaseLetters extends Addition {

	private static final long serialVersionUID = 656034254847615897L;

	private LowercaseLetters(Password password) {
        super(password);
    }

    public static LowercaseLetters of(Password password) {
        return new LowercaseLetters(password);
    }

    @Override
    protected Score calculateScore() {
        final String lower = filterOnlyLowerCase(password.getValue());
        if (lower.length() > 0) {
            return Score.of((password.getLength() - lower.length()) * 2);
        }
        return Score.ZERO;
    }

    public static String filterOnlyLowerCase(String value) {
        return value.replaceAll("[^a-z]", "");
    }

}
