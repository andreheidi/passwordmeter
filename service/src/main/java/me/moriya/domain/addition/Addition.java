package me.moriya.domain.addition;

import me.moriya.domain.Password;
import me.moriya.domain.Score;
import me.moriya.domain.checker.AbstractChecker;

public abstract class Addition extends AbstractChecker {

	private static final long serialVersionUID = -7521612021718653255L;

	protected Addition(Password password) {
        super(password);
    }

    protected abstract Score calculateScore();

}
