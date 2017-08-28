package me.moriya.domain.special;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

public class ListThreeSequencialChars {

    private static final String sequencialAlphas = "abcdefghijklmnopqrstuvwxyz";

    private static final String sequencialNumbers = "01234567890";

    private static final String sequencialSymbols = ")!@#$%^&*()";

    private final List<SequencialCharsCaseInsensitive> sequencials = Lists.newLinkedList();

    private final int minimumCharSequencial = 3;

    private ListThreeSequencialChars(String referencia, String value) {
        filtrarSequenciais(referencia, value);
    }

    public static ListThreeSequencialChars alphas(String value) {
        return new ListThreeSequencialChars(sequencialAlphas, value);
    }

    public static ListThreeSequencialChars numbers(String value) {
        return new ListThreeSequencialChars(sequencialNumbers, value);
    }

    public static ListThreeSequencialChars symbols(String value) {
        return new ListThreeSequencialChars(sequencialSymbols, value);
    }

    private void filtrarSequenciais(String referencia, String value) {
        for (int i = 0; i < referencia.length() - minimumCharSequencial; i++) {
            addSequencialCharsValido(referencia.substring(i, i + minimumCharSequencial), value);
        }
    }

    private void addSequencialCharsValido(String referencia, String value){
        SequencialCharsCaseInsensitive sequencialCharsCaseInsensitive = SequencialCharsCaseInsensitive.of(referencia, value);
        if (sequencialCharsCaseInsensitive.isSequencial()) {
            sequencials.add(sequencialCharsCaseInsensitive);
        }
    }

    public List<SequencialCharsCaseInsensitive> getSequencials() {
        return ImmutableList.copyOf(sequencials);
    }
}
