package Examinationsuppgift3;

import java.util.ArrayList;

//Skapar en Player klass
public class Player extends Fighter {
    //Sparar spelarens namn
    private String name;
    private int yPosition, xPosition;
    private int playerHealth = 100;
    private int playerStrength = 10;

    private final int playerStartingHealth;

    private ArrayList<Item> items = new ArrayList<>();

    public Player(String name, int startYPosition, int startXPosition, int playerHealth, int playerStrength) {
        this.name = name;
        yPosition = startYPosition;
        xPosition = startXPosition;
        this.playerHealth = playerHealth;
        this.playerStrength = playerStrength;
        playerStartingHealth = playerHealth;
    }

    public void addItem(Item item) {
        //Add the new item to the arraylist items
        this.items.add(item);

        // Check if the new item is a weapon, if so add the weapons damage to playerStrength
        if (item.getClass() == Weapon.class){
            setPlayerStrength(((Weapon) item).getDamage());
        }
    }

    public String getName() {
        return name;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }



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

    public int getPlayerHealth() {
        return playerHealth;
    }
    public int getPlayerStrength() {
        return playerStrength;
    }

    public void setPlayerStrength (int damage){
        playerStrength += damage;
    }

    //Sets player health, minimum is zero
    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
        if (this.playerHealth < 0){
            this.playerHealth = 0;
        }
    }
    public String getPlayerHealthString() {
        String monsterHealthString = "\u001b[32m" + playerHealth + "\u001b[0m";
        if ((double)playerHealth / playerStartingHealth < 0.3) {
            monsterHealthString = "\u001b[31m" + playerHealth + "\u001b[0m";
        }
        return monsterHealthString;
    }

}
