package me.moriya.domain.deduction;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class LetterOnly extends Deduction {

	private static final long serialVersionUID = 173768832559079623L;

	private LetterOnly(Password password) {
        super(password);
    }

    public static LetterOnly of(Password password) {
        return new LetterOnly(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()){
            String letters = password.getValue().replaceAll("[^A-Za-z]", "");
            if (letters.length() == password.getLength()) {
                return Score.of(letters.length());
            }
        }
        return Score.ZERO;
    }

}
