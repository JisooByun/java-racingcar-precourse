package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.utils.InputConsole;
import racinggame.utils.RandomNumberGeneratorImpl;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        String carNames = InputConsole.enterNameOfCars();
        String laps = InputConsole.enterLaps();
        RacingGame racingGame = new RacingGame(new Cars(carNames), new RandomNumberGeneratorImpl());
        playGame(racingGame, laps);
    }

    private static void playGame(RacingGame racingGame, String laps) {
        for (int i = 0; i < Integer.parseInt(laps); i++) {
            racingGame.startNextLap();
            System.out.println(racingGame.flushLapOutput());
        }
        System.out.println(racingGame.flushWinners());
    }
}
