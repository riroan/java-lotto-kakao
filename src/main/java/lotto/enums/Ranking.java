package lotto.enums;

public enum Ranking {
    FAIL(0), FIFTH(1), FOURTH(2), THIRD(3), SECOND(4), FIRST(5);

    final int value;

    Ranking(int value) {
        this.value = value;
    }

    public long getReward() {
        if (value == Ranking.FIRST.value) {
            return 2000000000;
        }

        if (value == Ranking.SECOND.value) {
            return 30000000;
        }

        if (value == Ranking.THIRD.value) {
            return 1500000;
        }

        if (value == Ranking.FOURTH.value) {
            return 50000;
        }

        if (value == Ranking.FIFTH.value) {
            return 5000;
        }

        return 0;
    }
}
