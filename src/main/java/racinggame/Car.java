package racinggame;

public class Car {
    private String name;
    private int position;
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

    public void tryToMove(int i) {
        if(GameUtils.isGo(i)){
            position++;
        };
    }

    public int getPosition() {
        return position;
    }
}
