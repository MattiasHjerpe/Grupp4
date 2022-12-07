package Examinationsuppgift2;

import java.util.Scanner;
import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;

public class Aventyrsspel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        meny();
    }
    private static void meny() {
        Scanner input = new Scanner(System.in);

        //skriver ut en meny
        System.out.printf("1. Starta nytt spel%n2. Avsluta%nVal: ");

            while(true) {
                int menyval = input.nextInt();
                switch (menyval) {
                    case 1: {
                        System.out.println("Startar spelet");
                        setupGame();
                        break;
                    }
                    case 2: {
                        System.out.println("Avslutar spelet");
                        System.out.println(Math.random() >= 0.5);
                        break;
                    }
                    default: {
                        System.out.printf("Vänligen mata in 1 eller 2%n");
                        break;
                    }
                }
            }
    }


    private static void setupGame() {
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
        new Room ("Room 1", 1, -1, -1, 2);
        new Room ("Room 2", -1, 1, -1, -1);
        new Room ("Room 3", 1, 2, 3, -1);
        new Room ("Room 4", -1, 1, -1, 2);
        new Room ("Room 5", -1, -1, 1, -1);
        new Room ("Room 6", 1, -1, -1, 2);
    }
}
