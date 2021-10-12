package racinggame;

import java.util.Comparator;

public class Car {
    private final String name;
    private int position;
    private static final int GO_MIN_NUMBER = 4;

    public Car(String name) {
        this.name = name.trim();
        this.position = 0;
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
        StringBuilder result = new StringBuilder(name + " : ");
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
