package lotto.domain;

import java.util.Objects;

public class Money {
    private static final long LOTTO_PRICE = 1000;
    private final long value;

    public Money(long value) {
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }

    public long divide(Money money) {
        return this.value / money.getValue();
    }

    public Money buyLotto(int count) {
        long need = count * LOTTO_PRICE;
        if (need > value) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
        return new Money(value - need);
    }

    public long canBuyCount() {
        return value / LOTTO_PRICE;
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
