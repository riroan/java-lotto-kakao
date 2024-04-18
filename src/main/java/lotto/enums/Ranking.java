package lotto.enums;

public enum Ranking {
    FAIL(0, 0), FIFTH(1, 5000), FOURTH(2, 50000), THIRD(3, 1500000), SECOND(4, 30000000), FIRST(5, 2000000000);

    private final int ix;
    private final long value;

    Ranking(int ix, long value) {
        this.ix = ix;
        this.value = value;
    }

    public static Ranking getRank(long answerCount, boolean isCorrectBonusBall) {
        if (answerCount == 6) {
            return Ranking.FIRST;
        }

        if (answerCount == 5 && isCorrectBonusBall) {
            return Ranking.SECOND;
        }

        if (answerCount == 5) {
            return Ranking.THIRD;
        }

        if (answerCount == 4) {
            return Ranking.FOURTH;
        }

        if (answerCount == 3) {
            return Ranking.FIFTH;
        }

        return Ranking.FAIL;
    }

    public long getValue() {
        return value;
    }
}
