package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    void 자동차이름은_5자만_가능하다(){
         assertThatThrownBy(()->new Car("123456")).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5자 이하로 작성해주세요.");
    }

}
