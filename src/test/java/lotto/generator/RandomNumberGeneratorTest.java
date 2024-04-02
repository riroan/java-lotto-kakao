package lotto.generator;

import lotto.Answer;
import lotto.Ball;
import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    void 랜덤_숫자_생성_생성자_테스트() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertThat(randomNumberGenerator).isNotNull();
    }

    @Test
    void 랜덤_로또_생성_테스트() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Lotto lotto = randomNumberGenerator.generateLotto();

        List<Ball> balls = lotto.getBalls();

        List<Integer> numbers = balls.stream()
                .map(Ball::getNumber)
                .collect(Collectors.toList());

        int uniqueNumbers = new HashSet<>(numbers).size();

        Assertions.assertAll(() -> {
            assertThat(numbers.size()).isEqualTo(6);
            for (int i = 0; i < 6; i++) {
                assertThat(numbers.get(i)).isBetween(1, 45);
            }
            assertThat(uniqueNumbers).isEqualTo(6);
        });
    }

    @Test
    void 랜덤_정답_생성_테스트() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Answer answer = randomNumberGenerator.generateAnswer();
        Lotto lotto = answer.getAnswerNumbers();
        Ball bonusBall = answer.getBonusNumber();
        int bonusNumber = bonusBall.getNumber();

        List<Ball> balls = lotto.getBalls();

        List<Integer> numbers = balls.stream()
                .map(Ball::getNumber)
                .collect(Collectors.toList());

        int uniqueNumbers = new HashSet<>(numbers).size();

        Assertions.assertAll(() -> {
            assertThat(numbers.size()).isEqualTo(6);
            for (int i = 0; i < 6; i++) {
                assertThat(numbers.get(i)).isBetween(1, 45);
            }
            assertThat(uniqueNumbers).isEqualTo(6);
            assertThat(bonusNumber).isBetween(1, 45);
        });
    }
}
