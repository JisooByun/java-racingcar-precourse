package racinggame.domain;

import racinggame.utils.RandomNumberGenerator;

public class RacingGame {
    private Cars cars;
    private final int laps;
    private String lapOutput;
    private RandomNumberGenerator generator;

    public RacingGame(Cars cars, int laps, RandomNumberGenerator generator) {
        this.cars = cars;
        this.generator = generator;
        this.laps = laps;
    }

    public String flushWinners() {
        return "최종 우승자는 " + cars.findWinners() + " 입니다.";
    }

    public void startNextLap() {
        cars.tryToMoveEachCar(generator);
        lapOutput = cars.flushOutput();
    }

    public String flushLapOutput(){
     return lapOutput;
    }

}
