package racinggame.domain;

import org.junit.jupiter.api.Test;
import racinggame.RandomNumberGeneratorStub;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.utils.InputConsole;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    private static final String NEW_LINE = System.lineSeparator();

    @Test
    void 자동자이름_좌우에_공백이_포함되어_있을경우_공백제거() {
        Car car = new Car(" Foo  ");
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
        assertThat(actual).isEqualTo("Foo : -");
    }

    @Test
    void 자동차가_두칸전진했을경우_두칸전진한것으로_출력() {
        Car car = new Car("Foo");
        car.tryToMove(4);
        car.tryToMove(4);
        String actual = car.flushOutput();
        assertThat(actual).isEqualTo("Foo : --");
    }
    @Test
    void 자동차가_한칸전진한뒤_멈춤했을경우_한칸전진한것으로_출력() {
        Car car = new Car("Foo");
        car.tryToMove(4);
        car.tryToMove(3);
        String actual = car.flushOutput();
        assertThat(actual).isEqualTo("Foo : -");
    }

    @Test
    void 자동차두대가_모두_한칸전진했을경우_모두_한칸전진한것으로_출력() {
        Cars cars = new Cars("Foo, Bar");
        cars.tryToMoveEachCar(new RandomNumberGeneratorStub(4));
        String actual = cars.flushOutput();
        assertThat(actual).isEqualTo("Foo : -"+NEW_LINE+"Bar : -"+NEW_LINE);
    }

    @Test
    void 자동차한대만_한칸전진했을경우_해당자동차만_한칸전진한것으로_출력() {
        Cars cars = new Cars("Foo, Bar");
        cars.tryToMoveEachCar(new RandomNumberGeneratorStub(4,3));
        String actual = cars.flushOutput();
        assertThat(actual).isEqualTo("Foo : -"+NEW_LINE+"Bar : "+NEW_LINE);
    }


    @Test
    void 모든_LAP종료후_결과가_특정_최종우승자는으로_시작() {
        RacingGame racingGame = new RacingGame(new Cars("Foo,Bar"), 1, new RandomNumberGeneratorStub(4));
        racingGame.startNextLap();
        String actual = racingGame.flushWinners();
        assertThat(actual).startsWith("최종 우승자는");
    }

    @Test
    void 모든_랩종료후_공동_우승자만_출력() {
        RacingGame racingGame = new RacingGame(new Cars("Foo,Bar,Baz"), 2, new RandomNumberGeneratorStub(4, 2, 5));
        racingGame.startNextLap();
        String actual = racingGame.flushWinners();
        assertThat(actual).isEqualTo("최종 우승자는 Foo, Baz 입니다.");
    }

    @Test
    void 모든_랩종료후_솔로_우승자만_출력() {
        RacingGame racingGame = new RacingGame(new Cars("Foo,Bar,Baz"), 2, new RandomNumberGeneratorStub(4, 2, 1));
        racingGame.startNextLap();
        String actual = racingGame.flushWinners();
        assertThat(actual).isEqualTo("최종 우승자는 Foo 입니다.");
    }
}
