package lotto.enums;

public enum Ranking {
    FAIL, FIFTH, FOURTH, THIRD, SECOND, FIRST;

    public static long getReward(Ranking ranking) {
        if (ranking == Ranking.FIRST) {
            return 2000000000;
        }

        if (ranking == Ranking.SECOND) {
            return 30000000;
        }

        if (ranking == Ranking.THIRD) {
            return 1500000;
        }

        if (ranking == Ranking.FOURTH) {
            return 50000;
        }

        if (ranking == Ranking.FIFTH) {
            return 5000;
        }

        return 0;
    }
}
