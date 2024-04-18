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

        int numberOfManualLotto = lottoView.inputNumberOfManualLotto();
        lottoSystem.validateNumberOfManualLotto(numberOfManualLotto);
        money.buyLotto(numberOfManualLotto);

        List<Lotto> allLottos = new ArrayList<>();

        lottoView.printManualLottosDescription();
        for (int i = 0; i < numberOfManualLotto; i++) {
            List<Integer> manualNumbers = lottoView.inputManualLottos();
            Lotto lotto = lottoSystem.convertNumbersToLotto(manualNumbers);
            allLottos.add(lotto);
        }

        List<Lotto> autoLottos = lottoSystem.buyAutoLotto(money);
        allLottos.addAll(autoLottos);

        Lottos lottos = new Lottos(allLottos);
        lottoView.printLottos(lottos);

        WinningNumber winningNumber = lottoView.inputAnswer();
        Result result = lottoSystem.scoreLottos(lottos, winningNumber);

        lottoView.printResult(result);

        Profit profit = lottoSystem.calculateProfit(result, lottos);
        lottoView.printProfit(profit);
    }
}
