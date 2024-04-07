package lotto;

import lotto.domain.*;
import lotto.generator.RandomLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoSystem {
    private static final Money LOTTO_PRICE = new Money(1000);
    private final RandomLottoGenerator numberGenerator;
    private long lottoCount;

    public LottoSystem() {
        this.numberGenerator = new RandomLottoGenerator();
        this.lottoCount = 0;
    }

    private long calculateLottoCount(Money money) {
        return money.divide(LOTTO_PRICE);
    }

    public List<Lotto> buyAutoLotto(int numberOfManualLotto) {
        return generateAutoLottos(lottoCount - numberOfManualLotto);
    }

    public void validateNumberOfManualLotto(int numberOfManualLotto) {
        if (numberOfManualLotto > lottoCount || numberOfManualLotto < 0) {
            throw new IllegalArgumentException("유효하지 않은 수동 구매 개수입니다!");
        }
    }

    public WinningNumber convertToAnswer(List<Integer> answerAndBonusNumber) {
        Lotto lotto = convertNumbersToLotto(answerAndBonusNumber.subList(0, 6));
        Ball bonusBall = new Ball(answerAndBonusNumber.get(6));

        return new WinningNumber(lotto, bonusBall);
    }

    public Lotto convertNumbersToLotto(List<Integer> numbers) {
        List<Ball> balls = numbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
        return new Lotto(balls);
    }

    private List<Lotto> generateAutoLottos(long count) {
        return numberGenerator.generateAutoLottos(count);
    }

    public Result scoreLottos(Lottos lottos, WinningNumber winningNumber) {
        return lottos.scoreLottos(winningNumber);
    }

    public Profit calculateProfit(Result result) {
        long reward = result.calculateReward();
        long seed = lottoCount * LOTTO_PRICE.getValue();

        return new Profit(reward, seed);
    }

    public void setLottoCount(Money money) {
        lottoCount = calculateLottoCount(money);
    }
}
