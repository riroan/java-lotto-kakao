package lotto.domain;

import java.util.List;

public class Lottos {
    private static final Money LOTTO_PRICE = new Money(1000);
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

    public Result scoreLottos(WinningNumber winningNumber) {
        Result result = new Result();
        for (Lotto lotto : values) {
            result.scoreLotto(lotto, winningNumber);
        }
        return result;
    }

    public long getSeed() {
        return values.size() * LOTTO_PRICE.getValue();
    }
}
