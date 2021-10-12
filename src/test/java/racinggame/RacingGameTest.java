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

    @Test
    void 자동자이름_좌우에_공백이_포함되어_있을경우_공백제거() {
        Car car = new Car(" Foo  ");
        assertThat(car.getName()).isEqualTo("Foo");
    }

    @Test
    void 자동차_이름_필드확인() {
         Car car= new Car("Foo");
         assertThat(car.getName()).isEqualTo("Foo");
    }

    @Test
    void 입력값이_Car객체로_분리되서_생성되는지_확인() {
        String input = "Foo, Bar, Baz";
        Cars cars = new Cars(input);
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);
        assertThat(car1.getName()).isEqualTo("Foo");
        assertThat(car2.getName()).isEqualTo("Bar");
        assertThat(car3.getName()).isEqualTo("Baz");
    }

    @Test
    void 랩이_끝날때_결과_출력() {
        RacingGame racingGame = new RacingGame(new Cars("Foo"), 1, new RandomNumberGeneratorImpl());
        racingGame.startRace();
        String actual = racingGame.flushOutput();
        assertThat(actual).startsWith("Foo:");
    }

    @Test
    void Laps이_1이고_GO일때_한칸_이동() {
        RacingGame game = new RacingGame(new Cars("Foo"), 1, new RandomNumberGeneratorStub(4));
        game.startLap();
        String actual = game.flushOutput();
        assertThat(actual).startsWith("Foo: -");
    }
/*
    @Test
    void random값이_4이상일경우에서_Laps이_2이면_두칸_이동() {
        RacingGame game = new RacingGame(new Cars("Foo"), 2, new RandomNumberGeneratorStub(4));
        game.startLap();
        game.startLap();
        String actual = game.flushOutput();
        assertThat(actual).startsWith("Foo: --");
    }*/

    @Test
    void random이_4일경우_자동차_1칸전진() {
        Car car = new Car("Foo");
        car.tryToMove(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void random이_3일경우_자동차_멈춤() {
        Car car = new Car("Foo");
        car.tryToMove(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차가_한칸전진했을경우_한칸전진한것으로_출력() {
        Car car = new Car("Foo");
        car.tryToMove(4);
        String actual = car.flushOutput();
        assertThat(actual).isEqualTo("Foo: -");
    }

    @Test
    void 자동차가_두칸전진했을경우_두칸전진한것으로_출력() {
        Car car = new Car("Foo");
        car.tryToMove(4);
        car.tryToMove(4);
        String actual = car.flushOutput();
        assertThat(actual).isEqualTo("Foo: --");
    }
    @Test
    void 자동차가_한칸전진한뒤_멈춤했을경우_한칸전진한것으로_출력() {
        Car car = new Car("Foo");
        car.tryToMove(4);
        car.tryToMove(3);
        String actual = car.flushOutput();
        assertThat(actual).isEqualTo("Foo: -");
    }

/*@Test
    void 트랙_모든_라운드를_실행한뒤_결과_출력() {
        RacingGame racingGame = new RacingGame(new Cars("Foo"), 5);
        racingGame.startRace();
        String actual = racingGame.flushOutput();
        assertThat(actual).startsWith("최종 우승자는");
    }*/
}
