package Examinationsuppgift3;

public class Door {
    private boolean isLocked;
    private Direction direction;

    private String belongsTo;

    public Door(boolean isLocked, Direction canMove, String belongsTo){
        this.isLocked = isLocked;
        direction = canMove;
        this.belongsTo = belongsTo;
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
