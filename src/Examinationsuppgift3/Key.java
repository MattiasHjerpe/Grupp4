package Examinationsuppgift3;

public class Key extends Item{
/*    public Key (String name, String description){
        super(name, description);
    }*/
    private boolean lockesUp;
    public Key (String name, String description, boolean lockesUp) {
        super(name, description);
        this.lockesUp = lockesUp;
    }
    public boolean getLockesUp(){
        return lockesUp;
    }
}
