package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        String carNames = InputConsole.enterNameOfCars();
        System.out.println("시도할 회수는 몇회인가요?");
        String laps = Console.readLine();
        RacingGame racingGame = new RacingGame(new Cars(carNames), Integer.parseInt(laps), new RandomNumberGeneratorImpl());
        runLaps(racingGame, laps);
        System.out.println(racingGame.flushWinners());
    }

    private static void runLaps(RacingGame racingGame, String laps) {
        for (int i = 0; i < Integer.parseInt(laps); i++) {
            racingGame.startNextLap();
            racingGame.flushLapOutput();
        }
    }
}
