package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoSystemTest {
    @Test
    void 로또_시스템_생성자_테스트() {
        LottoSystem lottoSystem = new LottoSystem(1);

        Assertions.assertThat(lottoSystem).isNotNull();
    }

    @Test
    void 랜덤_로또_용지_생성_테스트() {
        LottoSystem lottoSystem = new LottoSystem(1);
        Lotto lotto = lottoSystem.generateLotto();

        Assertions.assertThat(lotto).isNotNull();
    }

    @Test
    void 랜덤_로또_여러개_생성_테스트() {
        LottoSystem lottoSystem = new LottoSystem(3);
        Lottos lottos = lottoSystem.generateLottos();

        Assertions.assertThat(lottos.getSize()).isEqualTo(3);
    }
}
