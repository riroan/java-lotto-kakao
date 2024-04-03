package lotto.generator;

import lotto.domain.WinningNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public interface NumberGenerator {
    Lotto generateLotto();
    WinningNumber generateAnswer();
    Lottos generateLottos(long lottoCount);
}
