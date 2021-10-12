package racinggame;

public class RacingGame {
    private Cars cars;
    private final int laps;
    private RandomNumberGenerator generator;

    public RacingGame(Cars cars, int laps, RandomNumberGenerator generator) {
        this.cars = cars;
        this.generator = generator;
        this.laps = laps;
    }

    public String flushOutput() {
        return "최종 우승자는"+ cars.findWinners();
    }

    public void startRace() {
        for (int i = 0; i <laps; i++) {
            cars.tryToMoveEachCar(generator);
            System.out.println(cars.flushOutput());
        }
    }

}
