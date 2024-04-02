package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSystemTest {
    @Test
    void 로또_시스템_생성자_테스트() {
        LottoSystem lottoSystem = new LottoSystem();

        assertThat(lottoSystem).isNotNull();
    }

    @Test
    void 랜덤_로또_용지_생성_테스트() {
        LottoSystem lottoSystem = new LottoSystem();
        Lotto lotto = lottoSystem.generateLotto();

        assertThat(lotto).isNotNull();
    }

    @Test
    void 랜덤_로또_여러개_생성_테스트() {
        LottoSystem lottoSystem = new LottoSystem();
        Lottos lottos = lottoSystem.generateLottos(3);

        assertThat(lottos.getSize()).isEqualTo(3);
    }

    @Test
    void 돈_2500원으로_로또_구매_테스트() {
        LottoSystem lottoSystem = new LottoSystem();
        Lottos lottos = lottoSystem.buyLottos(2500);

        assertThat(lottos.getSize()).isEqualTo(2);
    }
}
