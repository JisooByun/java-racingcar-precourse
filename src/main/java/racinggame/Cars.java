package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    List<Car> cars;
    public Cars(String input) {
        cars = new ArrayList<>();
        String[] carNames= input.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public Car get(int index) {
        return cars.get(index);
    }
}
