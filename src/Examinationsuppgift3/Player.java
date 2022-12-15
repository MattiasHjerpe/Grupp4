package Examinationsuppgift3;

import java.util.ArrayList;

//Skapar en Player klass
public class Player extends Fighter {
    private final String name;
    private int yPosition, xPosition;
    private int playerHealth = 100, playerStrength = 10;
    private final int playerStartingHealth;

    //Arraylist med spelarens items
    private ArrayList<Item> items = new ArrayList<>();

    //Constructor, skapar ny spelare
    public Player(String name, int startYPosition, int startXPosition, int playerHealth, int playerStrength) {
        this.name = name;
        yPosition = startYPosition;
        xPosition = startXPosition;
        this.playerHealth = playerHealth;
        this.playerStrength = playerStrength;
        playerStartingHealth = playerHealth;
    }

    //Method(s)
    //Lägger till saker i spelarens "ryggsäck"
    public void addItem(Item item) {
        //Lägger till i arraylist
        this.items.add(item);

        // Kollar om det nya föremålet är ett vapen, lägger isåfall till vapnets damage i playerStrength(damage)
        if (item.getClass() == Weapon.class){
            setPlayerStrength(((Weapon) item).getDamage());
        }
    }

    //Styr spelarens rörelse
    public void moveNorth() {
        yPosition--;
    }
    public void moveEast() {
        xPosition++;
    }
    public void moveSouth() {
        yPosition++;
    }
    public void moveWest() {
        xPosition--;
    }

    //Setters
    //Set spelarens Strength
    public void setPlayerStrength (int damage){
        playerStrength += damage;
    }

    //Set spelarens hälsa, minimum 0
    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
        if (this.playerHealth < 0){
            this.playerHealth = 0;
        }
    }

    //Getters
    //Hämta spelarens namn
    public String getName() {
        return name;
    }

    //Hämta spelarens X position
    public int getXPosition() {
        return xPosition;
    }

    //Hämta spelarens Y position
    public int getYPosition() {
        return yPosition;
    }

    //Hämta spelarens hälsa
    public int getPlayerHealth() {
        return playerHealth;
    }

    //Hämta spelarens styrka
    public int getPlayerStrength() {
        return playerStrength;
    }

    //Hämta spelarens starthälsa
    private int getPlayerStartingHealth() {
        return playerStartingHealth;
    }

    //Returnerar en String med spelarens hälsa i rött om det är under 30% av ursprungshälsan, annars grönt
    public String getPlayerHealthString() {
        String playerHealthString = "\u001b[32m" + getPlayerHealth() + "\u001b[0m";
        if ((double)playerHealth / getPlayerStartingHealth() < 0.3) {
            playerHealthString = "\u001b[31m" + getPlayerHealth() + "\u001b[0m";
        }
        return playerHealthString;
    }
}
