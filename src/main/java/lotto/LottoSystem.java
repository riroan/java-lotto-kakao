package lotto;

import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

public class LottoSystem {
    private static final int LOTTO_PRICE = 1000;
    private NumberGenerator numberGenerator;
    private Result result;
    private long lottoCount;

    public LottoSystem() {
        this.numberGenerator = new RandomNumberGenerator();
        this.result = new Result();
        this.lottoCount = 0;
    }

    private long calculateLottoCount(long money) {
        return money / LOTTO_PRICE;
    }

    public Lottos buyLottos(long money) {
        lottoCount = calculateLottoCount(money);
        return generateLottos();
    }

    private Lottos generateLottos() {
        return numberGenerator.generateLottos(lottoCount);
    }

    public void scoreLottos(Lottos lottos, Answer answer) {
        for (int i = 0; i < lottoCount; i++) {
            scoreLotto(lottos.get(i), answer);
        }
    }

    public Result getResult() {
        return result;
    }

    public void scoreLotto(Lotto lotto, Answer answer) {
        result.scoreLotto(lotto, answer);
    }

    public Profit calculateProfit() {
        long reward = result.calculateReward();
        long seed = lottoCount * LOTTO_PRICE;

        return new Profit(reward, seed);
    }
}
