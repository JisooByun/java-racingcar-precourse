package racinggame;

public enum MoveStatus {
    GO,STOP;

    public boolean isGo() {
        return this == GO;
    }
}
