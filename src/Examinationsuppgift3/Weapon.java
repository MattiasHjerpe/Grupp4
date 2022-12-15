package Examinationsuppgift3;

public class Weapon extends Item{
    public Weapon(String name, String description){
        super(name, description);
    }
    private int damage = 20;
    public Weapon(String name, String description, int damage){
        super(name, description);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }


}
