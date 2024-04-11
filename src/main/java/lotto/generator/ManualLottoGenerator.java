package lotto.generator;

import lotto.domain.Ball;
import lotto.domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {
    private final List<Integer> numbers;
    public ManualLottoGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto generateLotto() {
        List<Ball> balls = numbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
        return new Lotto(balls);
    }
}
