package lotto;

public class Profit {
    private final long integerPart;
    private final long decimalPart;

    public Profit(long reward, int seed) {
        long result = reward * 100 / seed;
        this.integerPart = result / 100;
        this.decimalPart = result % 100;
    }

    @Override
    public String toString() {
        return String.format("%d.%d", this.integerPart, this.decimalPart);
    }
}
