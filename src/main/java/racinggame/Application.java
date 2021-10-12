package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(, ) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String round = Console.readLine();
        new RacingGame(new Cars(carNames), Integer.parseInt(round),new RandomNumberGeneratorImpl());
    }
}
