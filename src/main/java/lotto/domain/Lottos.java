package lotto.domain;

import lotto.domain.Lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getSize() {
        return this.lottos.size();
    }

    public Lotto get(int ix) {
        return lottos.get(ix);
    }
}
