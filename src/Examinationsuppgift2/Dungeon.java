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
    }
    public void playGame(Room room1, Room room2, Room room3, Room room4, Room room5, Room room6){

        enterTheDungeon();
        String[][] dungeonMap = { {"Room2", "Room4", "Room5"}, {"Room1", "Room3", null}, {null, "Room6", "RoomD"} };
        currentRoom = dungeonMap[1][0];
        int[] iy = {1, 0};


        while (!currentRoom.equals("RoomD")){
            switch(currentRoom) {

                case "Room1":
                    room1.doNarrative(iy);
                    currentRoom = dungeonMap[iy[0]][iy[1]];
                    break;
                case "Room2":
                        room2.doNarrative(iy);
                    currentRoom = dungeonMap[iy[0]][iy[1]];
                    break;
                case "Room3":
                        room3.doNarrative(iy);
                    currentRoom = dungeonMap[iy[0]][iy[1]];
                    break;
                case "Room4":
                        room4.doNarrative(iy);
                    currentRoom = dungeonMap[iy[0]][iy[1]];
                    break;
                case "Room5":
                        room5.doNarrative(iy);
                    currentRoom = dungeonMap[iy[0]][iy[1]];
                    break;
                case "Room6":
                        room6.doNarrative(iy);
                    currentRoom = dungeonMap[iy[0]][iy[1]];
                    break;
                default:
                    break;
            }
        }
        System.out.println("You died!");

    }
}
