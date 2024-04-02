package lotto.generator;

import lotto.Answer;
import lotto.Lotto;

import java.util.*;

public interface NumberGenerator {
    Lotto generateLotto();
    Answer generateAnswer();
}
