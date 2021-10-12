package racinggame;

public class RacingGame {

    private final int laps;
    private StringBuffer outputBuffer;
    private RandomNumberGenerator generator;

    public RacingGame(Cars cars, int laps, RandomNumberGenerator generator) {
        this.generator = generator;
        this.laps = laps;
    }

    public String flushOutput() {
        return "Foo: -";
    }

    public void startRace() {
        for (int i = 0; i <laps; i++) {
            startLap();
        }
    }

    public void startLap() {

    }
}
