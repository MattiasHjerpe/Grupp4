package Examinationsuppgift3;

//Skapar en Door class
public class Door {
    private boolean locked;
    private Direction direction;

    //Konstruktor för dörr
    public Door(boolean locked, Direction canMove) {
        this.locked = locked;
        direction = canMove;
    }

    //Getter för directions
    public Direction getDirection() {
        return direction;
    }

    //Kollar om dörren är låst
    public boolean isLocked() {
        return locked;
    }

}
