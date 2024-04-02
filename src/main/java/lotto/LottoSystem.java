package lotto;

import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class LottoSystem {
    private int lottoCount;
    private NumberGenerator numberGenerator;

    public LottoSystem(int lottoCount) {
        this.lottoCount = lottoCount;
        this.numberGenerator = new RandomNumberGenerator();
    }

    public Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount ; i++) {
            lottos.add(generateLotto());
        }

        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        return numberGenerator.generateLotto();
    }
}
