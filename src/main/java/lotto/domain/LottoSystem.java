package lotto.domain;

import lotto.generator.ManualLottoGenerator;
import lotto.generator.RandomLottoGenerator;

import java.util.List;

public class LottoSystem {
    private static final Money LOTTO_PRICE = new Money(1000);

    private long calculateLottoCount(Money money) {
        return money.divide(LOTTO_PRICE);
    }

    public List<Lotto> buyAutoLotto(Money money) {
        return generateAutoLottos(money.canBuyCount());
    }

    public void validateNumberOfManualLotto(int numberOfManualLotto) {
        if (numberOfManualLotto < 0) {
            throw new IllegalArgumentException("유효하지 않은 수동 구매 개수입니다!");
        }
    }

    public WinningNumber convertToAnswer(List<Integer> answerAndBonusNumber) {
        Lotto lotto = convertNumbersToLotto(answerAndBonusNumber.subList(0, 6));
        Ball bonusBall = new Ball(answerAndBonusNumber.get(6));

        return new WinningNumber(lotto, bonusBall);
    }

    public Lotto convertNumbersToLotto(List<Integer> numbers) {
        ManualLottoGenerator generator = new ManualLottoGenerator(numbers);
        return generator.generateLotto();
    }

    private List<Lotto> generateAutoLottos(long count) {
        RandomLottoGenerator generator = RandomLottoGenerator.getInstance();
        return generator.generateAutoLottos(count);
    }

    public Result scoreLottos(Lottos lottos, WinningNumber winningNumber) {
        return lottos.scoreLottos(winningNumber);
    }

    public Profit calculateProfit(Result result, Lottos lottos) {
        long reward = result.calculateReward();
        long seed = lottos.getSize() * LOTTO_PRICE.getValue();

        return new Profit(reward, seed);
    }
}