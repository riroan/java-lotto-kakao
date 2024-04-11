package lotto.domain;

import lotto.enums.Ranking;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Result {
    private final Map<Ranking, Integer> score;
    private long reward;

    public Result() {
        score = new HashMap<>();
        reward = 0L;
    }

    public void scoreLotto(Lotto lotto, WinningNumber winningNumber) {
        Ranking rank = winningNumber.match(lotto);
        addScore(rank);
    }

    public int getScore(Ranking rank) {
        return score.getOrDefault(rank, 0);
    }

    private void addScore(Ranking rank) {
        int rankScore = score.getOrDefault(rank, 0);
        score.put(rank, rankScore + 1);
    }

    public long calculateReward() {
        reward = 0L;

        for (Entry<Ranking, Integer> entry : score.entrySet()) {
            Ranking rank = entry.getKey();
            int count = entry.getValue();
            reward += rank.getReward() * count;
        }

        return reward;
    }
}
