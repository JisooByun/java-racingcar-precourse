package racinggame.domain;

import java.util.Comparator;

public class Car {

    private final String name;
    private Integer position;
    private static final Integer GO_MIN_NUMBER = 4;

    public Car(String name) {
        this.name = name.trim();
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryToMove(int number) {
        if(number >= GO_MIN_NUMBER){
            position++;
        }
    }

    public String flushOutput() {
        StringBuilder result = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public static Comparator<Car> carPositionComparator = (car1, car2) -> car2.getPosition() -car1.getPosition();
}
