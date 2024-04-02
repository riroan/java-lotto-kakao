package lotto.domain;

import lotto.domain.Ball;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<Ball> balls;

    public Lotto(List<Ball> balls) {
        validateBalls(balls);
        sortBalls(balls);
        this.balls = balls;
    }

    private void sortBalls(List<Ball> balls) {
        Collections.sort(balls);
    }

    private void validateBalls(List<Ball> balls) {
        validateNumberOfBalls(balls);
        validateDuplicatedBalls(balls);
    }

    private void validateNumberOfBalls(List<Ball> balls) {
        if (balls.size() != LOTTO_SIZE) {
            throw new RuntimeException();
        }
    }

    private void validateDuplicatedBalls(List<Ball> balls) {
        long count = balls.stream()
                .map(Ball::getNumber)
                .distinct()
                .count();
        if (count != LOTTO_SIZE) {
            throw new RuntimeException();
        }
    }

    public boolean contain(Ball target) {
        return balls.contains(target);
    }

    public List<Ball> getBalls() {
        return this.balls;
    }

    @Override
    public String toString() {
        List<String> numbers = balls.stream()
                .map(ball -> Integer.toString(ball.getNumber()))
                .collect(Collectors.toList());
        return "[" + String.join(", ", numbers) + "]";
    }
}
