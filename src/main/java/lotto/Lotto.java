package lotto;

import java.util.List;

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
        long count = balls.stream()
                .map(Ball::getNumber)
                .distinct()
                .count();
        if (count != LOTTO_SIZE) {
            throw new RuntimeException();
        }
    }

    public boolean contain(Ball target) {
        boolean isContained = this.balls
                .stream()
                .anyMatch(ball -> ball.getNumber() == target.getNumber());

        return isContained;
    }

    public List<Ball> getBalls() {
        return this.balls;
    }
}
