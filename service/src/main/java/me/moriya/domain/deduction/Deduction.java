package me.moriya.domain.deduction;

import me.moriya.domain.Password;
import me.moriya.domain.Score;
import me.moriya.domain.checker.AbstractChecker;

public abstract class Deduction extends AbstractChecker {

	private static final long serialVersionUID = 4444379782132993870L;

	protected Deduction(Password password) {
        super(password);
    }

    @Override
    protected Score calculateScore() {
        return calculate().negative();
    }

    protected abstract Score calculate();

}
