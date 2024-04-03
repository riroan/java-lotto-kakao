package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    void 생성자_테스트() {
        Money money = new Money(1000);
        assertThat(money).isNotNull();
    }

    @Test
    void 동일_금액_테스트() {
        Money money1 = new Money(1000);
        Money money2 = new Money(1000);
        assertThat(money1).isEqualTo(money2);
    }
}
