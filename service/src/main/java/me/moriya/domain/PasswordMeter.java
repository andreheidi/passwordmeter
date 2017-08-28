package me.moriya.domain;

import java.io.Serializable;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.moriya.domain.checker.Checker;
import me.moriya.domain.checker.CheckerFactory;

//import me.moriya.domain.checker.Password;

@Getter
public class PasswordMeter implements Serializable {

	private static final long serialVersionUID = -3620572106274443456L;

	private Password password;
	
	private Score score;
	
	private Complexity complexity;

    private PasswordMeter(Password password) {
        this.password = password;
        this.score = processScore();
        this.complexity = rangeComplexity();
    }

    public static PasswordMeter of(Password password) {
        Preconditions.checkNotNull(password, "Password não pode ser null");
        return new PasswordMeter(password);
    }

    private Score processScore() {
        return CheckerFactory.of(password).stream()
                .map(Checker::getScore)
                .reduce(Score.ZERO, Score::sum);
    }

    private Complexity rangeComplexity() {
        return Complexity.of(score);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof PasswordMeter) {
            PasswordMeter other = (PasswordMeter) object;
            return Objects.equal(this.password, other.password);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(password);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("password", password)
                .add("score", score)
                .add("complexity", complexity).toString();
    }

    public Password getPassword() {
        return password;
    }

    public Score getScore() {
        return score;
    }

    public Complexity getComplexity() {
        return complexity;
    }

}
