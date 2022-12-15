package Examinationsuppgift3;

import java.util.ArrayList;

//Skapar en Player klass
public class Player extends Fighter {
    private final String name;
    private int yPosition, xPosition;
    private int playerHealth = 100, playerStrength = 10;
    private final int playerStartingHealth;

    //Arraylist that contains the players items
    private ArrayList<Item> items = new ArrayList<>();

    //Constructor, creates a new player
    public Player(String name, int startYPosition, int startXPosition, int playerHealth, int playerStrength) {
        this.name = name;
        yPosition = startYPosition;
        xPosition = startXPosition;
        this.playerHealth = playerHealth;
        this.playerStrength = playerStrength;
        playerStartingHealth = playerHealth;
    }

    //Method(s)
    //Adds a new item to the players inventory, in the arraylist items
    public void addItem(Item item) {
        //Add the new item to the arraylist items
        this.items.add(item);

        // Check if the new item is a weapon, if so add the weapons damage to playerStrength(damage)
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
    //Sets player strength, if a new weapon is added it adds the damage to playerStrength
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

    //Getters
    //Gets the players name
    public String getName() {
        return name;
    }

    //Gets the players X position
    public int getXPosition() {
        return xPosition;
    }

    //Gets the players Y position
    public int getYPosition() {
        return yPosition;
    }

    //Gets player health
    public int getPlayerHealth() {
        return playerHealth;
    }

    //Gets player strength
    public int getPlayerStrength() {
        return playerStrength;
    }

    //Gets starting health, used by getPlayerHealthString()
    private int getPlayerStartingHealth() {
        return playerStartingHealth;
    }

    //Returns a string of the players health in either red, if its under 30% of its original health left, or green
    public String getPlayerHealthString() {
        String playerHealthString = "\u001b[32m" + getPlayerHealth() + "\u001b[0m";
        if ((double)playerHealth / getPlayerStartingHealth() < 0.3) {
            playerHealthString = "\u001b[31m" + getPlayerHealth() + "\u001b[0m";
        }
        return playerHealthString;
    }
}
