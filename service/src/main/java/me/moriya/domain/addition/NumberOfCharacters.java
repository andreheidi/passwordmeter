package me.moriya.domain.addition;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class NumberOfCharacters extends Addition {

	private static final long serialVersionUID = -8902184982938677400L;

	private NumberOfCharacters(Password password) {
        super(password);
    }

    public static NumberOfCharacters of(Password password) {
        return new NumberOfCharacters(password);
    }

    @Override
    protected Score calculateScore() {
        return Score.of(password.getLength() * 4);
    }

}
