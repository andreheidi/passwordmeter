package me.moriya.domain.addition;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class Symbols extends Addition {

	private static final long serialVersionUID = 6943558196999345191L;

	private Symbols(Password password) {
        super(password);
    }

    public static Symbols of(Password password) {
        return new Symbols(password);
    }

    @Override
    protected Score calculateScore() {
        return Score.of((filterOnlySymbols(password.getValue()).length()) * 6);
    }

    public static String filterOnlySymbols(String value) {
        return value.replaceAll("[\\w\\d]", "");
    }

}
