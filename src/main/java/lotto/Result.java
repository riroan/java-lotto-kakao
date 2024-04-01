package lotto;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<Ranking, Integer> score;

    public Result() {
        score = new HashMap<>();
    }

    public void scoreLotto(Lotto lotto, Answer answer) {
        long answerCount = answer.getAnswerNumbers().getBalls().stream().filter(lotto::contain).count();
        boolean isCorrectBonusBall = lotto.contain(answer.getBonusNumber());

        Ranking rank = getRank(answerCount, isCorrectBonusBall);
        addScore(rank);
    }

    public int getScore(Ranking rank) {
        return score.getOrDefault(rank, 0);
    }

    private void addScore(Ranking rank) {
        int rankScore = score.getOrDefault(rank, 0);
        score.put(rank, rankScore + 1);
    }


    private Ranking getRank(long answerCount, boolean isCorrectBonusBall) {
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
}
