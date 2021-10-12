package racinggame;

public class RandomNumberGeneratorStub implements RandomNumberGenerator{

    private int number;

    public RandomNumberGeneratorStub(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
