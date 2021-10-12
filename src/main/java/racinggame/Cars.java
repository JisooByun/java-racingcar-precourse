package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;
    public Cars(String input) {
        cars = new ArrayList<>();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public void tryToMoveEachCar(RandomNumberGenerator generator) {
        for (Car car : cars) {
            int number = generator.generate();
            car.tryToMove(number);
        }
    }

    public String flushOutput() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.flushOutput()).append(System.lineSeparator());
        }
        return result.toString();
    }
}
