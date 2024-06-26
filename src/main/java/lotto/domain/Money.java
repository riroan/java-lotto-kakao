package lotto.domain;

import java.util.Objects;

public class Money {
    private final long value;

    public Money(long value) {
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }

    public long divide (Money money) {
        return this.value / money.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
