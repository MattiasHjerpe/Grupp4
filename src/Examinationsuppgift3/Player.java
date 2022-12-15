package Examinationsuppgift3;

import java.util.ArrayList;

//Skapar en Player klass
public class Player extends Fighter {
    //Sparar spelarens namn
    private String name;

    private int yPosition;
    private int xPosition;
    private int playerHealth = 100;
    private int playerStrength = 10;

    private ArrayList<Item> items = new ArrayList<>();

    public Player(String name, int startYPosition, int startXPosition, int playerHealth, int playerStrength) {
        this.name = name;
        yPosition = startYPosition;
        xPosition = startXPosition;
        this.playerHealth = playerHealth;
        this.playerStrength = playerStrength;
    }

    public void addItem(Item item) {
        this.items.add(item);
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
    public int getplayerStrength() {
        return playerStrength;
    }
    public int setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
        return playerHealth;
    }

}
