package racinggame.utils;

import nextstep.utils.Console;

public class InputConsole {

    public static String enterNameOfCars() {
        String carNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(, ) 기준으로 구분)");
            carNames = Console.readLine();
        }
        while (!InputValidator.carNamesValidate(carNames));
        return carNames;
    }

    public static String enterLaps() {
        String input;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            input = Console.readLine();
        } while (!InputValidator.validateInputLaps(input));
        return input;
    }


}
