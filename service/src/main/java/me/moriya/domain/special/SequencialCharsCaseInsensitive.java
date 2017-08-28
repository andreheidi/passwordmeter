package me.moriya.domain.special;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class SequencialCharsCaseInsensitive {

    private final boolean sequencial;

    private final String value;

    private SequencialCharsCaseInsensitive(String referencia, String value) {
        checkNotNull(referencia, "Referencia não pode ser null");
        checkNotNull(value, "Value não pode ser null");
        this.value = referencia;
        this.sequencial = find(referencia, value.toLowerCase());
    }

    public static SequencialCharsCaseInsensitive of(String referencia, String value) {
        return new SequencialCharsCaseInsensitive(referencia, value);
    }

    private boolean find(String referencia, String value) {
        return value.contains(referencia) || reverseSequencial(referencia, value);
    }

    private boolean reverseSequencial(String referencia, String value) {
        return value.contains(new StringBuilder(referencia).reverse().toString());
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof SequencialCharsCaseInsensitive) {
            SequencialCharsCaseInsensitive other = (SequencialCharsCaseInsensitive) object;
            return Objects.equal(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value).toString();
    }

    public boolean isSequencial() {
        return sequencial;
    }
}
