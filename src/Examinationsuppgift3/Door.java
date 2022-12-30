package Examinationsuppgift3;

public class Door {
    private boolean locked;
    private Direction direction;

    public Door(boolean locked, Direction canMove) {
        this.locked = locked;
        direction = canMove;
    }


    public Direction getDirection() {
        return direction;
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        locked = false;
    }

}
