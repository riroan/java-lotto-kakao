package lotto.domain;

import lotto.domain.Lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public int getSize() {
        return values.size();
    }

    public Lotto get(int ix) {
        return values.get(ix);
    }

    public void scoreLottos(WinningNumber winningNumber, Result result) {
        for (Lotto lotto: values) {
            scoreLotto(lotto, winningNumber, result);
        }
    }

    private void scoreLotto(Lotto lotto, WinningNumber winningNumber, Result result) {
        result.scoreLotto(lotto, winningNumber);
    }
}
