package lotto.generator;

import lotto.domain.Ball;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LENGTH = 6;
    private final List<Ball> ballPool = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(Ball::new)
            .collect(Collectors.toList());

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

    public Lotto generateLotto() {
        List<Ball> balls = generateNumbers();
        return new Lotto(balls);
    }
}
