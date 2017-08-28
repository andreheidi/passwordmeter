package me.moriya.domain.deduction;

import me.moriya.domain.Password;
import me.moriya.domain.Score;
import me.moriya.domain.special.ListThreeSequencialChars;

public class SequencialNumbers extends Deduction {

	private static final long serialVersionUID = 5676206096909097757L;

	private SequencialNumbers(Password password) {
        super(password);
    }

    public static SequencialNumbers of(Password password) {
        return new SequencialNumbers(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Score.of(ListThreeSequencialChars.numbers(password.getValue())
                    .getSequencials().size() * 3);
        }
        return Score.ZERO;
    }

}
