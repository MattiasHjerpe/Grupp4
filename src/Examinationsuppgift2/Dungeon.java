package Examinationsuppgift2;

import java.util.Scanner;

public class Dungeon {
    private String currentRoom;
    public void enterTheDungeon(){
        Scanner input = new Scanner(System.in);
        //System.out.println("What is you name adventurer?");
        System.out.println("You stand in front of the Dungeon. Do you want to enter? Y/N");
        String option = input.nextLine().toLowerCase();
        if (option.equals("n")){
            System.out.println("You turn around and bravely run away.");
            System.exit(0);
        }
        System.out.println("You enter the Dungeon. There is a loud rumble and the opening collapses behind you");
        playGame();

        System.out.println("You died.");
    }
    public void playGame(){
        String[][] dungeonMap = { {"Room1", "Room4", "Room5"}, {"Room1", "Room3", null}, {null, "Room6", "RoomD"} };


        for(int i=0; i<dungeonMap.length; i++) {
            for (int j = 0; j < dungeonMap[i].length; j++) {
            }
        }

        currentRoom = dungeonMap[1][0];
        System.out.println(currentRoom);
    }
}
