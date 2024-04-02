package lotto.domain;

public class Profit {
    private final long integerPart;
    private final long decimalPart;

    public Profit(long reward, long seed) {
        if (seed == 0) {
            this.integerPart = 1;
            this.decimalPart = 0;
            return;
        }
        long result = reward * 100 / seed;
        this.integerPart = result / 100;
        this.decimalPart = result % 100;
    }

    public String getGainOrLoss() {
        if (integerPart == 1 && decimalPart == 0) {
            return "이익도 손해도 아니";
        }

        if (integerPart < 1) {
            return "손해";
        }

        return "이익이";
    }

    @Override
    public String toString() {
        return String.format("%d.%d", this.integerPart, this.decimalPart);
    }
}
