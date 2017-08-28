package me.moriya.domain.deduction;

import me.moriya.domain.Password;
import me.moriya.domain.Score;

public class RepeatCharactersCaseInsensitive extends Deduction {

	private static final long serialVersionUID = -5648043548725745517L;

	private RepeatCharactersCaseInsensitive(Password password) {
        super(password);
    }

    public static RepeatCharactersCaseInsensitive of(Password password) {
        return new RepeatCharactersCaseInsensitive(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            int charRepeated = 0;
            double repeatIncrement = 0;
            for (int a = 0; a < password.getLength(); a++) {
                boolean charExists = false;
                for (int b = 0; b < password.getLength(); b++) {
                    if (password.getValue().charAt(a) == password.getValue().charAt(b) && a != b) {
                        charExists = true;
                        repeatIncrement += Math.abs((double) password.getLength() / (b - a));
                    }
                }
                if (charExists) {
                    charRepeated++;
                    int uniqueChar = password.getLength() - charRepeated;
                    if (uniqueChar > 0) {
                        repeatIncrement = Math.ceil(repeatIncrement / uniqueChar);
                    } else {
                        repeatIncrement = Math.ceil(repeatIncrement);
                    }
                }
            }
            if (charRepeated > 0) {
                return Score.of((int) repeatIncrement);
            }
        }
        return Score.ZERO;
    }

}
