package racinggame;

public class GameUtils {

    public static MoveStatus checkGoOrStop(int randomNumber) {
        return randomNumber >= 4 ? MoveStatus.GO : MoveStatus.STOP;
    }
}
