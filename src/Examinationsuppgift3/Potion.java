package Examinationsuppgift3;

//Skapar en Potion class som ärver Item
public class Potion extends Item {
    //Ger potion värdet 100 för att hela spelaren när den används
    private int healing = 100;

    //Konstruktor för potion
    public Potion(String name, String description, int healing) {
        super(name, description);
        this.healing = healing;
    }
}



