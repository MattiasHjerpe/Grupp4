package Examinationsuppgift2;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class DragonTreasure {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        meny();


    }
    private static void meny() {
        Scanner input = new Scanner(System.in);

        //skriver ut en meny
        System.out.printf("1. Begin your adventure%n2. Quit%nChoose: ");


            while(true) {
                int menyval = input.nextInt();
                switch (menyval) {
                    case 1: {

                        //Dungeon gamestart = new Dungeon();
                        //gamestart.playGame();
                        setupGame();



                        break;
                    }
                    case 2: {
                        System.out.println("Quit");
                        System.out.println(Math.random() >= 0.5);
                        break;
                    }
                    default: {
                        System.out.printf("Please choose 1 or 2%n");
                        break;
                    }
                }
            }
    }

    public static void setupGame() {
        //String[][] rooms = {{"Room1", "North", "East", null, null, "rum 1 descitptionn"}, {"Room2", null, null, "South", null, "rumm222"}};

        Room room1 = new Room();
        room1.RoomFacts("Room1", "North", "East", null, null,
                "Two worn statues mark the entrance to the dungeon. The room is dark but you see two doorways. You can go North or East.");
        Room room2 = new Room();
        room2.RoomFacts("Room2", null, null, "South", null,
                "The room is filled with boxes, seems to be a storageroom. It is a dead end, you can only go South.");
        Room room3 = new Room();
        room3.RoomFacts("Room3", "North", null, "South", "West",
                "You move forward deeper into the dungeon. There is a dining room table in the middle of the room with several lit candles. Someone must have recently been here. You can go North, South or West");
        Room room4 = new Room();
        room4.RoomFacts("Room4", null, "East", "South", null,
                "You come across a worn down kitchen. There is a fire in the woodstove. You can go East or South.");
        Room room5 = new Room();
        room5.RoomFacts("Room5", null, null, null, "West",
                "Seems to be a food pantry. There is a rotten smell in the air. It is a dead end, you can only go West");
        Room room6 = new Room();
        room6.RoomFacts("Room6", "North", "East", null, null,
                "There are several torches along the walls leading up to a door. You wonder whats behind the door. You can either go through the door East or go back North.");

        Dungeon newDungeon = new Dungeon();
        newDungeon.playGame(room1, room2, room3, room4, room5, room6);


        //skicka in alla nya room i dungeon?


        //room1.RoomFacts(rooms[0][0], rooms[0][1], rooms[0][2], rooms[0][3], rooms[0][4], rooms[0][5]);
        //room2.RoomFacts(rooms[1][0], rooms[1][1], rooms[1][2], rooms[1][3], rooms[1][4], rooms[1][5]);
        //room1.doNarrative();

    }

    public static void startGame(){

    }


    private static void slumpRum() {
        //Storleken på dungeon, ettan är startpunkten
        int[][] dungeonMap = { {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0} };
        //Två arrayer för att spara x och y
        ArrayList<Integer> potentialRoomI = new ArrayList<Integer>();
        ArrayList<Integer> potentialRoomJ = new ArrayList<Integer>();
        int  a, b, c, d, e, f, i = 0, j = 2;
        Random randomTal = new Random();

        //Ifall i är under 4 (sista raden i dungeon) så skapa fler rum
        while (i < 4){
            //int roomPercentage = randomTal.nextInt(100);

            //if satserna kollar så inte rum läggs till utanför arrayen gränser
            if (j > 0){
                    a = i;
                    b = j - 1;
                    potentialRoomI.add(a);
                    potentialRoomJ.add(b);
            }
            if (j < 4){
                    c = i;
                    d = j + 1;
                    potentialRoomI.add(c);
                    potentialRoomJ.add(d);
            }
            //i är alltid mindre än arrayen gränser och kan säkert läggas till
            e = i + 1;
            f = j;
            potentialRoomI.add(e);
            potentialRoomJ.add(f);

            //dungeon går alltid rakt fram första steget
            if (i == 0){
                dungeonMap[i + 1][j] = 1;
                i = 1;

                //slumpar ett rum, fram eller någon av sidorna från tidigare sparade arrayer potentialRoomI & J
            } else {
                int randomArray = randomTal.nextInt(potentialRoomI.size());
                dungeonMap[potentialRoomI.get(randomArray)][potentialRoomJ.get(randomArray)] = 1;
                i = potentialRoomI.get(randomArray);
                j = potentialRoomJ.get(randomArray);
            }
/*
            //användes för till att slumpa in ett extra rum ibland
            if (roomPercentage < 20 && i != 0){
                int randomArray = randomTal.nextInt(potentialRoomI.size());
                dungeonMap[potentialRoomI.get(randomArray)][potentialRoomJ.get(randomArray)] = 1;
                System.out.println("jag aktiverades");
            }
            */

            //rensar båda arrayerna för att ge plats åt nya potentiella rum
            potentialRoomJ.removeAll(potentialRoomJ);
            potentialRoomI.removeAll(potentialRoomI);

        }

        //Skriver ut kartan över dungeon
        for (int z = 0; z < 5; z++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(dungeonMap[z][x] + " ");
            }
            System.out.println();
        }
    }
}
