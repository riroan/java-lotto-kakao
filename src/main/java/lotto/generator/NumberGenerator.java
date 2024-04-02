package lotto.generator;

import lotto.Answer;
import lotto.Lotto;
import lotto.Lottos;

import java.util.*;

public interface NumberGenerator {
    Lotto generateLotto();
    Answer generateAnswer();
    Lottos generateLottos(long lottoCount);
}
