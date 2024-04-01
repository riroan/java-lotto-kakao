package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
    @Test
    void 볼_생성자_테스트() {
        Ball ball = new Ball(1);
        assertThat(ball).isNotNull();
        assertThat(ball.getNumber()).isEqualTo(1);
    }

    @Test
    void 볼_번호_범위_테스트() {
        assertThatThrownBy(() -> {
            new Ball(46);
        }).isInstanceOf(RuntimeException.class);
    }
}
