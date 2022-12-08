package Examinationsuppgift2;
//Importerar Scanner
import java.util.Scanner;
// Skapar en public class med namnet DragonTreasure
public class DragonTreasure {
    // SKapar en main metod
    public static void main(String[] args) {
        //Kallar på menyn
        meny();
    }
    private static void meny() {
        //Skapar scanner för att ta emot menyval
        Scanner input = new Scanner(System.in);
        //skriver ut en meny
        System.out.printf("1. Begin your adventure%n2. Quit%nChoose: ");
        //Skapar menyval. Om 1 startar spelet. Om 2 avslutar spelet. Om annan input upprepas frågan
            while(true) {
                int menyval = input.nextInt();
                switch (menyval) {
                    case 1: {
                        setupGame();
                        break;
                    }
                    case 2: {
                        System.out.println("Quit");
                        System.exit(0);
                        break;
                    }
                    default: {
                        System.out.printf("Please choose 1 or 2%n");
                        break;
                    }
                }
            }
    }
    //Skapar rummen med hjälp av konstruktorn i Room. Ger information om varje rum i RoomFacts.
    public static void setupGame() {
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
        //Skapar en dungeon med hjälp av Dungeon konstruktoren innehållande alla rum som tidigare skapats
        Dungeon newDungeon = new Dungeon();
        newDungeon.playGame(room1, room2, room3, room4, room5, room6);
    }
}