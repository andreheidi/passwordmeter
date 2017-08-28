package me.moriya.domain.deduction;

import me.moriya.domain.Password;
import me.moriya.domain.Score;
import me.moriya.domain.special.ListThreeSequencialChars;

public class SequencialLetters extends Deduction {

	private static final long serialVersionUID = -3800736261108764113L;

	private SequencialLetters(Password password) {
        super(password);
    }

    public static SequencialLetters of(Password password) {
        return new SequencialLetters(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Score.of(ListThreeSequencialChars.alphas(password.getValue())
                    .getSequencials().size() * 3);
        }
        return Score.ZERO;
    }

}
