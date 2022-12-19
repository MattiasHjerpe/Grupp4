package Examinationsuppgift3;

public class Key extends Item{

    private boolean unlocks;
    public Key (String name, String description, boolean unlocks) {
        super(name, description);
        this.unlocks = unlocks;
    }
    public boolean getUnlocks(){
        return unlocks;
    }
}
