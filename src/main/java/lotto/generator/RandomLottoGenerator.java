package lotto.generator;

import lotto.domain.Ball;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LENGTH = 6;

    private static RandomLottoGenerator instance;
    private final List<Ball> ballPool = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(Ball::new)
            .collect(Collectors.toList());

    private RandomLottoGenerator() {
    }

    public static RandomLottoGenerator getInstance() {
        if (instance == null) {
            synchronized (RandomLottoGenerator.class) {
                if (instance == null) {
                    instance = new RandomLottoGenerator();
                }
            }
        }
        return instance;
    }

    private List<Ball> generateNumbers() {
        Collections.shuffle(ballPool);
        return new ArrayList<>(ballPool.subList(0, RandomLottoGenerator.LENGTH));
    }

    public List<Lotto> generateAutoLottos(long lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    @Override
    public Lotto generateLotto() {
        List<Ball> balls = generateNumbers();
        return new Lotto(balls);
    }
}
