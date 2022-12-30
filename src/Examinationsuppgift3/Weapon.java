package Examinationsuppgift3;

//Skapar en Weapon class som ärver Item
public class Weapon extends Item {

    //Variabel som sparar vapnets skada
    private int damage;

    //Konstruktor för weapon
    public Weapon(String name, String description, int damage){
        super(name, description);
        this.damage = damage;
    }

    //Skapar en getter för weapon
    public int getDamage() {
        return damage;
    }
}
