package Examinationsuppgift3;
//Importerar Scanner

import java.util.Scanner;

public class Dungeon {

    private final Room[][] dungeonMap;
    private final Room start;
    private final int startXPosition;
    private final int startYPosition;
    private final Room end;

    public Dungeon(Room[][] dungeonMap, Room start, int startYPosition, int startXPosition, Room end) {
        this.dungeonMap = dungeonMap;
        this.start = start;
        this.startXPosition = startXPosition;
        this.startYPosition = startYPosition;
        this.end = end;
    }


    public Room getStart() {
        return start;
    }

    public Room getEnd() {
        return end;
    }

    public int getStartYPosition() {
        return startYPosition;
    }

    public int getStartXPosition() {
        return startXPosition;
    }

    public Room getRoom(int yPosition, int xPosition) {
        return dungeonMap[yPosition][xPosition];
    }

    //Metod för uppstarten av spelet, frågar spelaren vad den vill göra
    public void enterTheDungeon() {
        Scanner input = new Scanner(System.in);

        //Start adventure
        System.out.println("You stand in front of the Dungeon. Do you want to enter? Y/N");
        String option = input.nextLine().toLowerCase();
        if (option.equals("n")) {
            System.out.println("You turn around and bravely run away.");
            System.exit(0);
        }
        System.out.println("You enter the Dungeon. There is a loud rumble and the opening collapses behind you");
    }
}
