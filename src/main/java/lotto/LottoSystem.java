package lotto;

import lotto.domain.*;
import lotto.generator.RandomLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoSystem {
    private static final Money LOTTO_PRICE = new Money(1000);
    private final RandomLottoGenerator numberGenerator;
    private final Result result;
    private long lottoCount;

    public LottoSystem() {
        this.numberGenerator = new RandomLottoGenerator();
        this.result = new Result();
        this.lottoCount = 0;
    }

    private long calculateLottoCount(Money money) {
        return money.divide(LOTTO_PRICE);
    }

    public Lottos buyLottos(Money money) {
        lottoCount = calculateLottoCount(money);
        return generateLottos();
    }

    public WinningNumber convertToAnswer(List<Integer> answerAndBonusNumber) {
        List<Ball> answerBalls = answerAndBonusNumber.subList(0, 6)
                .stream()
                .map(Ball::new)
                .collect(Collectors.toList());
        Ball bonusBall = new Ball(answerAndBonusNumber.get(6));

        Lotto lotto = new Lotto(answerBalls);
        return new WinningNumber(lotto, bonusBall);
    }

    private Lottos generateLottos() {
        return numberGenerator.generateLottos(lottoCount);
    }

    public void scoreLottos(Lottos lottos, WinningNumber winningNumber) {
        for (int i = 0; i < lottoCount; i++) {
            scoreLotto(lottos.get(i), winningNumber);
        }
    }

    public Result getResult() {
        return result;
    }

    public void scoreLotto(Lotto lotto, WinningNumber winningNumber) {
        result.scoreLotto(lotto, winningNumber);
    }

    public Profit calculateProfit() {
        long reward = result.calculateReward();
        long seed = lottoCount * LOTTO_PRICE.getValue();

        return new Profit(reward, seed);
    }
}
