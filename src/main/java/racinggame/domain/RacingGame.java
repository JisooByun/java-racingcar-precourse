package racinggame.domain;

import racinggame.utils.RandomNumberGenerator;

public class RacingGame {

    private final Cars cars;
    private String lapOutput;
    private final RandomNumberGenerator generator;

    public RacingGame(Cars cars, RandomNumberGenerator generator) {
        this.cars = cars;
        this.generator = generator;
    }

    public void startNextLap() {
        cars.tryToMoveEachCar(generator);
        lapOutput = cars.flushOutput();
    }

    public String flushWinners() {
        return "최종 우승자는 " + cars.findWinners() + " 입니다.";
    }

    public String flushLapOutput(){
        return lapOutput;
    }

}
