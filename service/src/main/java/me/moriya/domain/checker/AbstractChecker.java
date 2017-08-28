package me.moriya.domain.checker;

import java.io.Serializable;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public abstract class AbstractChecker implements Serializable, Checker {

	private static final long serialVersionUID = 8052419391737567743L;

	protected final Password password;

    protected final Score score;

    protected AbstractChecker(Password password) {
        this.password = password;
        this.score = calculateScore();
    }

    protected abstract Score calculateScore();

    @Override
    public boolean equals(Object object) {
        if (object instanceof AbstractChecker) {
            AbstractChecker other = (AbstractChecker) object;
            return Objects.equal(this.password, other.password) &&
                    Objects.equal(this.score, other.score);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(password, score);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("password", password)
                .add("score", score).toString();
    }

    @Override
    public Score getScore() {
        return score;
    }

}
