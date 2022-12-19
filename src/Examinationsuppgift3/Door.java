package Examinationsuppgift3;

public class Door {
    private boolean isLocked;
    private Direction direction;


    public Door(boolean isLocked, Direction canMove){
        this.isLocked = isLocked;
        direction = canMove;
    }


    public Direction getDirection() {
        return direction;
    }

    public boolean getIsLocked(){
        return isLocked;
    }

    public void setIsLocked(boolean isLocked){
        System.out.println("You unlock the door.");
        this.isLocked = isLocked;
    }
}
