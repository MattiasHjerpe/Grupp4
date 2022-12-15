package Examinationsuppgift3;
//Importerar Scanner

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Skapar en public class med namnet DragonTreasure
public class DragonTreasure {
    // SKapar en main metod
    public static void main(String[] args) {
        var dungeon = createDungeon();
        playGame(dungeon);
    }

    //Skapar rummen med hjälp av konstruktorn i Room. Ger information om varje rum i RoomFacts.
    public static Dungeon createDungeon() {
        Room room1 = new Room(
                "Two worn statues mark the entrance to the dungeon. The room is dark but you see two doorways. You can go North or East.",
                new Door(false, Direction.NORTH), new Door(false, Direction.EAST));
        Room room2 = new Room(
                "The room is filled with boxes, seems to be a storageroom. It is a dead end, you can only go South.",
                new Weapon("Sword", "Deadly af", 20),
                new Door(false, Direction.SOUTH));
        Room room3 = new Room(
                "You move forward deeper into the dungeon. There is a dining room table in the middle of the room with several lit candles. \nSomeone must have recently been here. You can go North, South or West",
                new Monster("Goblin", 1, 1),
                new Door(false, Direction.SOUTH), new Door(false, Direction.WEST), new Door(false, Direction.NORTH));
        Room room4 = new Room(
                "You come across a worn down kitchen. There is a fire in the woodstove. You can go East or South.",
                new Potion("health potion", "I feel good nanananana", 100),
                new Door(false, Direction.EAST), new Door(false, Direction.SOUTH));
        Room room5 = new Room(
                "Seems to be a food pantry. There is a rotten smell in the air. It is a dead end, you can only go West",
                new Key("Key", "unlocks door... what did you think?", true),
                new Door(false, Direction.WEST));
        Room room6 = new Room(
                "There are several torches along the walls leading up to a door. You wonder whats behind the door. \nYou can either go through the door East or go back North.",
                new Door(false, Direction.NORTH), new Door(false, Direction.EAST));
        Room roomD = new Room("A dragon ambushes you! Prepare to fight!",
                new Monster("Dragon", 1, 1),
                new Door(false, Direction.WEST), new Door(false, Direction.EAST));
        Room roomE = new Room("End room");
        //Skapar en dungeon med hjälp av Dungeon konstruktoren innehållande alla rum som tidigare skapats
        Room[][] dungeonMap = {{room2, room4, room5}, {room1, room3, null}, {null, room6, roomD, roomE}};
        return new Dungeon(dungeonMap, room1, 1, 0, roomE);
    }


    //Här spelas spelet, metoden tar med sig objekten room1-6 och skapar en scanner för att senare kunna flytta spelaren
    public static void playGame(Dungeon dungeon) {
        Scanner input = new Scanner(System.in);

        //Skapar en karta över dungeon med hjälp av en multidimensional array
        //Sparar var spelaren startar
        Room currentRoom = dungeon.getStart();

        //Ber spelaren ange ett namn
        System.out.println("What is you name adventurer?");
        String name = input.nextLine();
        //Skapar en ny spelare med hjälp av Player konstruktorn
        Player player1 = new Player(name, dungeon.getStartYPosition(), dungeon.getStartXPosition(), 100, 10);

        //Kör metoden som startar igång spelet utanför dungeon
        dungeon.enterTheDungeon();

        //Sålänge inte spelaren nått sista rummet, RoomD, så går spelaren mellan rum i Switch satsen
        String wrongWay = "You stare at the wall, there is nothing there. You turn around.";
        while (!currentRoom.equals(dungeon.getEnd())) {
            menuBar(player1, currentRoom.canMove(Direction.NORTH), currentRoom.canMove(Direction.EAST), currentRoom.canMove(Direction.SOUTH), currentRoom.canMove(Direction.WEST));
            currentRoom.doNarrative();
            if (currentRoom.hasMonster()) {
                //Scanner input = new Scanner(System.in);
                Monster monster = currentRoom.getMonster();
                monster.fightSequence(player1, monster);
                /*if (option.equals("y")) {
                    System.out.println("You picked up the " + item);
                    player1.addItem(item);
                    currentRoom.removeItem();
                }*/
            }
            if (currentRoom.hasItem()) {
                //Scanner input = new Scanner(System.in);
                Item item = currentRoom.getItem();
                System.out.println("You see " + item + ", do you want to pick it up? Y/N");
                String option = input.nextLine().toLowerCase();
                if (option.equals("y")) {
                    System.out.println("You picked up the " + item);
                    player1.addItem(item);
                    currentRoom.removeItem();
                }
            }
            System.out.print("Where do you go: ");
            var direction = input.nextLine().toLowerCase();
            switch (direction) {
                case "n":
                case "north":
                    if (currentRoom.canMove(Direction.NORTH)) {
                        player1.moveNorth();
                    } else {
                        System.out.println(wrongWay);
                    }
                    break;
                case "e":
                case "east":
                    if (currentRoom.canMove(Direction.EAST)) {
                        player1.moveEast();
                    } else {
                        System.out.println(wrongWay);
                    }
                    break;
                case "s":
                case "south":
                    if (currentRoom.canMove(Direction.SOUTH)) {
                        player1.moveSouth();
                    } else {
                        System.out.println(wrongWay);
                    }
                    break;
                case "w":
                case "west":
                    if (currentRoom.canMove(Direction.WEST)) {
                        player1.moveWest();
                    } else {
                        System.out.println(wrongWay);
                    }
                    break;
                case "m":
                case "map":
                    dungeon.getDungeonMap();
                    //direction = input.nextLine().toLowerCase();
                    break;
                default:
                    break;
            }

            currentRoom = dungeon.getRoom(player1.getYPosition(), player1.getXPosition());
        }
        System.out.println("You found a treasure!");
        System.out.println(
                "                  _.--.\n" +
                        "              _.-'_:-'||\n" +
                        "          _.-'_.-::::'||\n" +
                        "     _.-:'_.-::::::'  ||\n" +
                        "   .'`-.-:::::::'     ||\n" +
                        "  /.'`;|:::::::'      ||_\n" +
                        " ||   ||::::::'      _.;._'-._\n" +
                        " ||   ||:::::'   _.-!oo @.!-._'-.\n" +
                        " \'.  ||:::::.-!() oo @!()@.-'_.||\n" +
                        "   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n" +
                        "     `>'-.!@%()@'@_%-'_.-o _.|'||\n" +
                        "      ||-._'-.@.-'_.-' _.-o  |'||\n" +
                        "      ||=[ '-._.-\\U/.-'    o |'||\n" +
                        "      || '-.]=|| |'|      o  |'||\n" +
                        "      ||      || |'|        _| ';\n" +
                        "      ||      || |'|    _.-'_.-'\n" +
                        "      |'-._   || |'|_.-'_.-'\n" +
                        "      '-._'-.|| |' `_.-'\n" +
                        "           '-.||_/.-'\n");
        System.out.println("You notice a door behind the treasure chest. You escaped!");
        System.out.println("Well done, " + name + "!");
        //Avslutar spelet
        System.exit(0);
        /*//Skapar ett slumpat nummer mellan 1 och 3
        int secretNumber = 1 + (int) (Math.random() * 3);
        //Skriver ut en av två möjliga endings beroende på det slumpade numret
        if (secretNumber == 2) {
            System.out.println("A dragon ambushes you. Sadly the programmer have not coded in any weapons for you and you are no match for the dragon...");
            
            System.out.println("Too bad, " + player1.getName() + ", you died!");
            //Avslutar spelet
            System.exit(0);
        } else {*/

        }
    //}
    private static void menuBar(Player player, Boolean northCheck, Boolean eastCheck, Boolean southCheck, Boolean westCheck) {
        Integer health = player.getPlayerHealth();
        String healthPlayer = "\u001b[32m" + health.toString() + "\u001b[0m";
        String breaks = "%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n";
        String shorts = "----------------------------------------------";
        String longs = "-------------------------------------------------------";
        String north = "\u001b[32mNorth\u001b[0m", east = "\u001b[32mEast\u001b[0m", south = "\u001b[32mSouth\u001b[0m", west = "\u001b[32mWest\u001b[0m";

        if (!northCheck){
            north = "\u001b[31mNorth\u001b[0m";
        }
        if (!eastCheck){
            east = "\u001b[31mEast\u001b[0m";
        }
        if (!southCheck){
            south = "\u001b[31mSouth\u001b[0m";
        }
        if (!westCheck){
            west = "\u001b[31mWest\u001b[0m";
        }
        if(health < 30){
            healthPlayer = "\u001b[31m" + health.toString() + "\u001b[0m";
        }


        System.out.printf(breaks);
        System.out.printf("%n%s%n| Health: %s | Map: M | Potion: P | Weapon:  |%n%s%n", shorts, healthPlayer, longs);
        System.out.printf("| Available Directions: | %s | %s | %s | %s |%n%s%n%n%n", north, east, south, west, longs);
    }



}