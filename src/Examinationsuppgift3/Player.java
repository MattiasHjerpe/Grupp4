package Examinationsuppgift3;

//Skapar en Player klass
public class Player {
    //Sparar spelarens namn
    private String name;

    private int yPosition;
    private int xPosition;

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
}
