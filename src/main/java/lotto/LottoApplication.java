package lotto;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();
        LottoView lottoView = new LottoView();

        long money = lottoView.inputMoney();
        Lottos lottos = lottoSystem.buyLottos(money);
        lottoView.printLottos(lottos);

        List<Integer> answerAndBonusNumber = lottoView.inputAnswer();

        List<Ball> answerBalls = answerAndBonusNumber.subList(0, 6)
                .stream()
                .map(Ball::new)
                .collect(Collectors.toList());
        Ball bonusBall = new Ball(answerAndBonusNumber.get(6));

        Lotto lotto = new Lotto(answerBalls);
        Answer answer = new Answer(lotto, bonusBall);

        lottoSystem.scoreLottos(lottos, answer);

        Result result = lottoSystem.getResult();

        lottoView.printResult(result);

        Profit profit = lottoSystem.calculateProfit();
        lottoView.printProfit(profit);
    }
}
