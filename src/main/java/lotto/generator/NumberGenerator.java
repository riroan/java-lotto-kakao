package lotto.generator;

import lotto.domain.Answer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public interface NumberGenerator {
    Lotto generateLotto();
    Answer generateAnswer();
    Lottos generateLottos(long lottoCount);
}
