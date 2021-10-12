package racinggame;

import java.util.Comparator;

public class Car {
    private final String name;
    private int position;
    private static final int GO_MIN_NUMBER = 4;

    public Car(String name) {
        validateNameBlank(name);
        String noSpaceName = name.trim();
        validateNameLength(noSpaceName);
        this.name = noSpaceName;
        this.position = 0;
    }

    private void validateNameBlank(String name) {
        if(name == null || "".equals(name)){
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다. 1~5자 로 작성해주세요.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
        }
    }

    public String getName() {
        return name;
    }

    public void tryToMove(int number) {
        if(number >= GO_MIN_NUMBER){
            position++;
        };
    }

    public int getPosition() {
        return position;
    }

    public String flushOutput() {
        StringBuilder result = new StringBuilder(name + ": ");
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public static Comparator<Car> carPositionComparator = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            return car2.getPosition() -car1.getPosition();
        }
    };
}
