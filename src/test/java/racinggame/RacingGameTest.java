package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    void 자동차이름은_5자만_가능하다(){
         assertThatThrownBy(()->new Car("123456")).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5자 이하로 작성해주세요.");
    }

    @Test
    void 자동차이름이_없으면_Exception_발생() {
        assertThatThrownBy(()->new Car("")).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 공백일 수 없습니다. 1~5자 로 작성해주세요.");
    }

    @Test
    void 자동차이름이_null이면_Exception_발생() {
        assertThatThrownBy(()->new Car(null)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 공백일 수 없습니다. 1~5자 로 작성해주세요.");
    }
}
