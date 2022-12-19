package Examinationsuppgift3;

public class Potion extends Item {

    private int healing = 100;

    public Potion(String name, String description, int healing) {
        super(name, description);
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }
}



