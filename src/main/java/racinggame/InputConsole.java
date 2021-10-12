package racinggame;

import nextstep.utils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputConsole {

    public static String enterNameOfCars() {
        String carNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(, ) 기준으로 구분)");
            carNames = Console.readLine();
        }
        while (!carNamesValidate(carNames));
        return carNames;
    }

    private static boolean carNamesValidate(String carNamesStr) {
        try {
            validateCarNames(carNamesStr);
            validateSeperateCarName(carNamesStr);
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    static void validateCarNames(String carNamesStr) {
        validateCarNameDuplicate(carNamesStr);
    }

    private static void validateCarNameDuplicate(String carNamesStr) {
        List<String> carNameList = Arrays.asList(carNamesStr.split(","));
        Set<String> carNameSet = new HashSet<>(carNameList);
        if(carNameList.size() != carNameSet.size()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    static void validateSeperateCarName(String carNamesStr) {
        String [] carNames = carNamesStr.split(",");
        for (String carName : carNames) {
            validateNameBlank(carName);
            String noSpaceName = carName.trim();
            validateNameLength(noSpaceName);
        }
    }

    private static void validateNameBlank(String name) {
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없습니다. 1~5자 로 작성해주세요.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 작성해주세요.");
        }
    }
}
