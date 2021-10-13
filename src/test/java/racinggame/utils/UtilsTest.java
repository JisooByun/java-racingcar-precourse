package racinggame.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UtilsTest {
    @Test
    void 자동차이름은_5자만_가능하다() {
        assertThatThrownBy(() -> InputConsole.validateSeperateCarName("123456")).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 자동차 이름은 5자 이하로 작성해주세요.");
    }

    @Test
    void 자동차이름_입력안하면_Exception_발생() {
        assertThatThrownBy(() -> InputConsole.validateSeperateCarName("")).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 자동차 이름은 공백일 수 없습니다. 1~5자 로 작성해주세요.");
    }

    @Test
    void 자동차이름_중복되면_Exception_발생() {
        assertThatThrownBy(() -> InputConsole.validateCarNames("Foo,Baz,Foo")).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 시도횟수입력시_숫자아니면_Exception발생(){
        assertThatThrownBy(() -> InputConsole.validateLaps("tes2t")).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    void 시도횟수입력시_0_또는_음수면_Exception발생(){
        assertThatThrownBy(() -> InputConsole.validateLaps("0")).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 시도 횟수는 1이상 입력해주세요.");
    }

    @Test
    void 시도횟수입력시_공백이면_Exception발생(){
        assertThatThrownBy(() -> InputConsole.validateLaps("")).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 공백이 아닌 숫자를 입력해주세요.");
    }
}
