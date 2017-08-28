package me.moriya.domain.addition;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class Numbers extends Addition {

	private static final long serialVersionUID = 320491241544723212L;

	private Numbers(Password password) {
        super(password);
    }

    public static Numbers of(Password password) {
        return new Numbers(password);
    }

    @Override
    protected Score calculateScore() {
        final String numbers = filterOnlyNumbers(password.getValue());
        if (numbers.length() != password.getLength()) {
            return Score.of((numbers.length()) * 4);
        }
        return Score.ZERO;
    }

    public static String filterOnlyNumbers(String value) {
        return value.replaceAll("[^0-9]", "");
    }

}
