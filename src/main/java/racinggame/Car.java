package racinggame;

public class Car {
    public Car(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
        }
    }


}
