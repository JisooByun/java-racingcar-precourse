package racinggame.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static boolean carNamesValidate(String carNamesStr) {
        try {
            validateCarNames(carNamesStr);
            validateSeperateCarName(carNamesStr);
            return true;
        } catch (IllegalArgumentException e) {
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
        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    static void validateSeperateCarName(String carNamesStr) {
        String[] carNames = carNamesStr.split(",");
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

    /*시도 회수 validator*/
    static boolean validateInputLaps(String laps) {
        try {
            validateLaps(laps);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    static void validateLaps(String laps) {
        validateInputNoBlank(laps);
        validateInputOnlyDigit(laps);
        validateInputMoreThanOrEqualToOne(laps);
    }

    private static void validateInputNoBlank(String laps) {
        if ("".equals(laps)) {
            throw new IllegalArgumentException("[ERROR] 공백이 아닌 숫자를 입력해주세요.");
        }
    }

    private static void validateInputMoreThanOrEqualToOne(String laps) {
        if (Integer.parseInt(laps) < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1이상 입력해주세요.");
        }
    }

    private static void validateInputOnlyDigit(String laps) {
        if (!laps.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
