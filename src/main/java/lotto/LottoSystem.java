package lotto;

import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

public class LottoSystem {
    private static final int LOTTO_PRICE = 1000;
    private NumberGenerator numberGenerator;

    public LottoSystem() {
        this.numberGenerator = new RandomNumberGenerator();
    }

    private int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public Lottos buyLottos(int money) {
        int lottoCount = calculateLottoCount(money);
        return generateLottos(lottoCount);
    }

    public Lottos generateLottos(int lottoCount) {
        return numberGenerator.generateLottos(lottoCount);
    }

    public Lotto generateLotto() {
        return numberGenerator.generateLotto();
    }
}
