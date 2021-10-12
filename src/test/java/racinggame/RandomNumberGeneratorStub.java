package racinggame;

public class RandomNumberGeneratorStub implements RandomNumberGenerator {

    private int[] numbers;
    private int index;

    public RandomNumberGeneratorStub(int... numbers) {
        this.numbers = numbers;
        index = 0;
    }

    @Override
    public int generate() {
        int number = numbers[index];
        index = (index + 1) % numbers.length;
        return number;

    }
}
