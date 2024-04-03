package lotto.generator;

import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LENGTH = 6;
    private final List<Ball> ballPool;

    public RandomLottoGenerator() {
        this.ballPool = new ArrayList<>();
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .forEach(number -> ballPool.add(new Ball(number)));
    }

    private List<Ball> generateNumbers(int length) {
        Collections.shuffle(ballPool);
        return new ArrayList<>(ballPool.subList(0, length));
    }

    public Lottos generateLottos(long lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        List<Ball> balls = generateNumbers(LENGTH);
        return new Lotto(balls);
    }

    public WinningNumber generateWinningNumber() {
        List<Ball> balls = generateNumbers(LENGTH + 1);
        Lotto lotto = new Lotto(balls.subList(0, LENGTH));
        Ball bonusBall = balls.get(LENGTH);

        return new WinningNumber(lotto, bonusBall);
    }
}
