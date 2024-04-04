package lotto.generator;

import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

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

    private List<Ball> generateNumbers() {
        Collections.shuffle(ballPool);
        return new ArrayList<>(ballPool.subList(0, RandomLottoGenerator.LENGTH));
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
        List<Ball> balls = generateNumbers();
        return new Lotto(balls);
    }
}
