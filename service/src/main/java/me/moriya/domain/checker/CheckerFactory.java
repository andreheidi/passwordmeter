package me.moriya.domain.checker;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import com.google.common.collect.ImmutableList;

import me.moriya.domain.Password;
import me.moriya.domain.addition.LowercaseLetters;
import me.moriya.domain.addition.MiddleNumbersOrSymbols;
import me.moriya.domain.addition.NumberOfCharacters;
import me.moriya.domain.addition.Numbers;
import me.moriya.domain.addition.Requirements;
import me.moriya.domain.addition.Symbols;
import me.moriya.domain.addition.UppercaseLetters;
import me.moriya.domain.deduction.ConsecutiveLowerCaseLetters;
import me.moriya.domain.deduction.ConsecutiveNumbers;
import me.moriya.domain.deduction.ConsecutiveUpperCaseLetters;
import me.moriya.domain.deduction.LetterOnly;
import me.moriya.domain.deduction.NumbersOnly;
import me.moriya.domain.deduction.RepeatCharactersCaseInsensitive;
import me.moriya.domain.deduction.SequencialLetters;
import me.moriya.domain.deduction.SequencialNumbers;
import me.moriya.domain.deduction.SequencialSymbols;

public class CheckerFactory {
	
    public static List<Checker> of(Password password) {
        checkNotNull(password, "password não pode ser null");
        
        ImmutableList.Builder<Checker> builder = ImmutableList.builder();
        
        builder.add(NumberOfCharacters.of(password));
        builder.add(UppercaseLetters.of(password));
        builder.add(LowercaseLetters.of(password));
        builder.add(Numbers.of(password));
        builder.add(Symbols.of(password));
        builder.add(MiddleNumbersOrSymbols.of(password));
        builder.add(Requirements.of(password));

        builder.add(LetterOnly.of(password));
        builder.add(NumbersOnly.of(password));
        builder.add(RepeatCharactersCaseInsensitive.of(password));
        builder.add(ConsecutiveUpperCaseLetters.of(password));
        builder.add(ConsecutiveLowerCaseLetters.of(password));
        builder.add(ConsecutiveNumbers.of(password));
        builder.add(SequencialLetters.of(password));
        builder.add(SequencialNumbers.of(password));
        builder.add(SequencialSymbols.of(password));

        return builder.build();
    }

}
