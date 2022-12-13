package Examinationsuppgift3;

//Skapar en Player klass
public class Player extends Fighter {
    //Sparar spelarens namn
    private String name;

    private int yPosition;
    private int xPosition;
    private int playerHealth = 100;
    private int playerStrength = 10;

    public Player(String name, int startYPosition, int startXPosition) {
        this.name = name;
        yPosition = startYPosition;
        xPosition = startXPosition;
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

    public int getplayerHealth() {
        return playerHealth;
    }

}
