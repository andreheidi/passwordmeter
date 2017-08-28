package me.moriya.domain.deduction;

import me.moriya.domain.Password;
import me.moriya.domain.Score;
import me.moriya.domain.addition.Numbers;

public class NumbersOnly extends Deduction {

	private static final long serialVersionUID = -7782179070349052411L;

	private NumbersOnly(Password password) {
        super(password);
    }

    public static NumbersOnly of(Password password) {
        return new NumbersOnly(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()){
            String numbers = Numbers.filterOnlyNumbers(password.getValue());
            if (numbers.length() == password.getLength()) {
                return Score.of(numbers.length());
            }
        }
        return Score.ZERO;
    }

}
