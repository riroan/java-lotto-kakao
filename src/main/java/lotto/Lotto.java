package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<Ball> balls;

    public Lotto(List<Ball> balls) {
        validateBalls(balls);
        this.balls = balls;
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
        Set<Integer> numbers = balls.stream()
                .map(Ball::getNumber)
                .collect(Collectors.toSet());
        if (numbers.size() != LOTTO_SIZE) {
            throw new RuntimeException();
        }
    }
}
