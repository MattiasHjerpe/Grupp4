package Examinationsuppgift3;

//Skapar en Weapon class som ärver Item
public class Weapon extends Item {

    //Gör så att man med svärdet gör 20 skada
    private int damage;

    //Skapar en setter för weapon
    public Weapon(String name, String description, int damage){
        super(name, description);
        this.damage = damage;
    }

    //Skapar en getter för weapon
    public int getDamage() {
        return damage;
    }
}
