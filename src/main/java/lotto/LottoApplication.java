package lotto;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();
        LottoView lottoView = new LottoView();

        Money money = new Money(lottoView.inputMoney());
        lottoSystem.setLottoCount(money);

        int numberOfManualLotto = lottoView.inputNumberOfManualLotto();
        lottoSystem.validateNumberOfManualLotto(numberOfManualLotto);

        List<Lotto> allLottos = new ArrayList<>();

        lottoView.printManualLottosDescription();
        for (int i = 0; i < numberOfManualLotto; i++) {
            List<Integer> manualNumbers = lottoView.inputManualLottos();
            Lotto lotto = lottoSystem.convertNumbersToLotto(manualNumbers);
            allLottos.add(lotto);
        }

        List<Lotto> autoLottos = lottoSystem.buyAutoLotto(numberOfManualLotto);
        allLottos.addAll(autoLottos);

        Lottos lottos = new Lottos(allLottos);
        lottoView.printLottos(lottos);

        List<Integer> answerAndBonusNumber = lottoView.inputAnswer();
        WinningNumber winningNumber = lottoSystem.convertToAnswer(answerAndBonusNumber);
        lottoSystem.scoreLottos(lottos, winningNumber);

        Result result = lottoSystem.getResult();
        lottoView.printResult(result);

        Profit profit = lottoSystem.calculateProfit();
        lottoView.printProfit(profit);
    }
}
