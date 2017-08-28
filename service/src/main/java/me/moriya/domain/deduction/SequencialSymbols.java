package me.moriya.domain.deduction;

import me.moriya.domain.Password;
import me.moriya.domain.Score;
import me.moriya.domain.special.ListThreeSequencialChars;

public class SequencialSymbols extends Deduction {

	private static final long serialVersionUID = 1939180760015455054L;

	private SequencialSymbols(Password password) {
        super(password);
    }

    public static SequencialSymbols of(Password password) {
        return new SequencialSymbols(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Score.of(ListThreeSequencialChars.symbols(password.getValue())
                    .getSequencials().size() * 3);
        }
        return Score.ZERO;
    }

}
