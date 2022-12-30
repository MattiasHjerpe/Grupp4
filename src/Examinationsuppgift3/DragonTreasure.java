package Examinationsuppgift3;
//Importerar Scanner

import java.util.ArrayList;
import java.util.Scanner;

// Skapar en public class med namnet DragonTreasure
public class DragonTreasure {
    private static final Scanner INPUT = new Scanner(System.in);

    // SKapar en main metod
    public static void main(String[] args) {
        var dungeon = createDungeon();
        playGame(dungeon);
    }

    //Skapar rummen med hjälp av konstruktorn i Room. Ger information om varje rum i RoomFacts.
    public static Dungeon createDungeon() {
        Room room1 = new Room(
                "Two worn statues mark the entrance to the dungeon. The room is dark but you see two doorways. You can go North or East.",
                new Door(false, Direction.NORTH),
                new Door(false, Direction.EAST));
        Room room2 = new Room(
                "The room is filled with boxes, seems to be a storageroom. ",
                new Weapon("Sword", "(+10 Damage)", 10),
                new Door(false, Direction.SOUTH));
        Room room3 = new Room(
                "You move forward deeper into the dungeon. There is a dining room table in the middle of the room with several lit candles. \nSomeone must have recently been here. ",
                new Monster("Goblin", 1, 1),
                new Door(false, Direction.SOUTH),
                new Door(false, Direction.WEST),
                new Door(false, Direction.NORTH));
        Room room4 = new Room(
                "You come across a worn down kitchen. There is a fire in the woodstove. ",
                new Potion("Health Potion", "(Restores Health)", 100),
                new Door(false, Direction.EAST),
                new Door(false, Direction.SOUTH));
        Room room5 = new Room(
                "Seems to be a food pantry. There is a rotten smell in the air. It is a dead end, you can only go West",
                new Key("Key", "(Master Key)"),
                new Door(false, Direction.WEST));
        Room room6 = new Room(
                "There are several torches along the walls leading up to a door. You wonder whats behind the door. \nYou can either go through the door East or go back North.",
                new Door(false, Direction.NORTH),
                new Door(true, Direction.EAST));
        Room roomD = new Room("A dragon ambushes you! Prepare to fight!",
                new Monster("Dragon", 1, 1),
                new Door(false, Direction.WEST),
                new Door(false, Direction.EAST));
        Room roomE = new Room("End room");
        //Skapar en dungeon med hjälp av Dungeon konstruktoren innehållande alla rum som tidigare skapats
        Room[][] dungeonMap = {{room2, room4, room5}, {room1, room3, null}, {null, room6, roomD, roomE}};
        return new Dungeon(dungeonMap, room1, 1, 0, roomE);
    }


    //Här spelas spelet, metoden tar med sig objekten room1-6 och skapar en scanner för att senare kunna flytta spelaren
    public static void playGame(Dungeon dungeon) {
        //Sparar var spelaren startar
        Room currentRoom = dungeon.getStart();
        //Ber spelaren ange ett namn
        System.out.println("What is your name adventurer?");
        String name = INPUT.nextLine();
        //Skapar en ny spelare med hjälp av Player konstruktorn
        Player player1 = new Player(name, dungeon.getStartYPosition(), dungeon.getStartXPosition(), 100, 10);

        //Kör metoden som startar igång spelet utanför dungeon
        dungeon.enterTheDungeon();

        //Sålänge inte spelaren nått sista rummet, RoomE, så går spelaren mellan rum i Switch satsen
        while (!currentRoom.equals(dungeon.getEnd())) {
            //Boolean som används för att kolla om spelaren slagits mot ett monster senare
            boolean foughtMonster = false;
            //Skriver ut en menybar
            menuBar(player1, currentRoom.canMove(Direction.NORTH), currentRoom.canMove(Direction.EAST), currentRoom.canMove(Direction.SOUTH), currentRoom.canMove(Direction.WEST));
            //Skriver ut beskrivningen av rummet
            currentRoom.doNarrative();

            //Kollar om det finns något monster i rummet
            if (currentRoom.hasMonster()) {
                //Skapar en instans av ett monster
                Monster monster = currentRoom.getMonster();
                //Startar en fight
                monster.fightSequence(player1, monster);
                //Sparar så programmet vet att ett monster slagits mot just nu
                foughtMonster = true;
            }

            //Kollar om rummet har en item som spelaren kan plocka upp
            if (currentRoom.hasItem()) {
                //Skapar en instans av item
                Item item = currentRoom.getItem();
                //Skriver ut en fråga till spelaren om den vill plocka upp
                System.out.println("You see " + item + ", do you want to pick it up? Y/N");
                String option = INPUT.nextLine().toLowerCase();

                //Ifall ja, så lägg till det nya itemet i spelarens "ryggsäck" och ta bort den från rummet
                if (option.equals("y")) {
                    System.out.println("You picked up the " + item);
                    player1.addItem(item);
                    currentRoom.removeItem();
                    player1.setNumberOfItemsPickedUp();
                }
            }
            //Kollar om du nyss slagits mot en monster, terminalen är då fylld av text, skriver då ut directions igen
            if (foughtMonster) {
                System.out.println(RoomDirections(currentRoom));
            } else {
                System.out.print("Where do you want to go: ");
            }

            //Spelaren input
            var direction = INPUT.nextLine().toLowerCase();
            //Boolean som kontrollerar om switch satsen ska upprepas eller om spelaren gått ut ur rummet
            boolean noMovement = true;
            while (noMovement) {
                String wrongWay = "You stare at the wall, there is nothing there. You turn around.";

                //Switch sats som väntar på vad spelaren ska göra i rummet (gå något håll, kolla map eller dricka potion)
                switch (direction) {

                    //Spelaren provar gå norr
                    case "n":
                    case "north":
                        //Kontrollerar om spelaren kan gå norr
                        if (currentRoom.canMove(Direction.NORTH)) {
                            //Kontrollerar om dörren är låst
                            if (shouldMovePlayer(currentRoom, player1, Direction.NORTH)) {
                                currentRoom.unlockDoor(Direction.NORTH);
                                //Flyttar spelaren norrut
                                player1.moveNorth();
                                noMovement = false;
                            } else{
                                System.out.println(RoomDirections(currentRoom));
                                direction = INPUT.nextLine().toLowerCase();
                                break;
                            }
                        //Om spelaren inte kan gå norr, men ändå försöker, skriv då ut ett felmeddelande
                        } else {
                            System.out.println(wrongWay);
                            System.out.println(RoomDirections(currentRoom));
                            direction = INPUT.nextLine().toLowerCase();
                        }
                        break;

                    //Spelaren provar gå öst
                    case "e":
                    case "east":
                        if (currentRoom.canMove(Direction.EAST)) {
                            if (shouldMovePlayer(currentRoom, player1, Direction.EAST)) {
                                currentRoom.unlockDoor(Direction.EAST);
                                player1.moveEast();
                                noMovement = false;
                            } else{
                                System.out.println(RoomDirections(currentRoom));
                                direction = INPUT.nextLine().toLowerCase();
                                break;
                            }
                        } else {
                            System.out.println(wrongWay);
                            System.out.println(RoomDirections(currentRoom));
                            direction = INPUT.nextLine().toLowerCase();
                        }
                        break;

                    //Spelaren provar gå söderut
                    case "s":
                    case "south":
                        if (currentRoom.canMove(Direction.SOUTH)) {
                            if (shouldMovePlayer(currentRoom, player1, Direction.SOUTH)) {
                                currentRoom.unlockDoor(Direction.SOUTH);
                                player1.moveSouth();
                                noMovement = false;
                            } else{
                                System.out.println(RoomDirections(currentRoom));
                                direction = INPUT.nextLine().toLowerCase();
                                break;
                            }
                        } else {
                            System.out.println(wrongWay);
                            System.out.println(RoomDirections(currentRoom));
                            direction = INPUT.nextLine().toLowerCase();
                        }
                        break;

                    //Spelaren provar gå västerut
                    case "w":
                    case "west":
                        if (currentRoom.canMove(Direction.WEST)) {
                            if (shouldMovePlayer(currentRoom, player1, Direction.WEST)) {
                                currentRoom.unlockDoor(Direction.WEST);
                                player1.moveWest();
                                noMovement = false;
                            } else{
                                System.out.println(RoomDirections(currentRoom));
                                direction = INPUT.nextLine().toLowerCase();
                                break;
                            }
                        } else {
                            System.out.println(wrongWay);
                            System.out.println(RoomDirections(currentRoom));
                            direction = INPUT.nextLine().toLowerCase();
                        }
                        break;

                    //Skriver ut en karta
                    case "m":
                    case "map":
                        dungeon.getDungeonMap(player1, currentRoom);
                        System.out.println(RoomDirections(currentRoom));
                        direction = INPUT.nextLine().toLowerCase();
                        break;

                    //Spelaren väljer att använda en potion
                    case "p":
                    case "potion":
                        player1.usePotion();
                        System.out.println(RoomDirections(currentRoom));
                        direction = INPUT.nextLine().toLowerCase();
                        break;
                    default:
                        break;
                }
            }
            //Uppdaterar currentRoom
            currentRoom = dungeon.getRoom(player1.getYPosition(), player1.getXPosition());
        }

        //Spelaren överlevde drakfighten och får då en skatt
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
        //Skriver ut statistik
        player1.playerStatistics();
        //Avslutar spelet
        System.exit(0);
    }

    //Metod för att skriva ut en menybar
    private static void menuBar(Player player, Boolean northCheck, Boolean eastCheck, Boolean southCheck, Boolean westCheck) {
        //Variabler som sparar spelarens health och olika directions
        Integer health = player.getPlayerHealth();
        String healthPlayer = "\u001b[32m" + health.toString() + "\u001b[0m";
        String breaks = "%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n";
        String shorts = "---------------------------------------------------";
        String longs = "-------------------------------------------------------";
        String north = "\u001b[32mNorth\u001b[0m", east = "\u001b[32mEast\u001b[0m", south = "\u001b[32mSouth\u001b[0m", west = "\u001b[32mWest\u001b[0m";

        //Kontrollerar tillgängliga dörrar, om inte tillgängliga ändra färg på texten till röd
        if (!northCheck) {
            north = "\u001b[31mNorth\u001b[0m";
        }
        if (!eastCheck) {
            east = "\u001b[31mEast\u001b[0m";
        }
        if (!southCheck) {
            south = "\u001b[31mSouth\u001b[0m";
        }
        if (!westCheck) {
            west = "\u001b[31mWest\u001b[0m";
        }

        //Ifall spelaren hälsopoäng är under 40, ändra text till röd
        if (health < 40) {
            healthPlayer = "\u001b[31m" + health.toString() + "\u001b[0m";
        }

        //Skriver ut menybar
        System.out.printf(breaks);
        System.out.printf("%n%s%n| Health: %s | Map: M | Potion(%s): P | Damage: %s |%n%s%n", shorts, healthPlayer, player.getNumberOfPotions(), player.getPlayerStrength(), longs);
        System.out.printf("| Available Directions: | %s | %s | %s | %s |%n%s%n%n%n", north, east, south, west, longs);
    }

    //En metod som kontrollerar vilka håll spelaren kan gå åt baserat på tillgängliga dörrar
    public static String RoomDirections(Room currentRoom) {
        //Sparar tillgängliga väderstreck
        ArrayList<String> directionsNESW = new ArrayList<String>();
        //String som kommer skrivas ut
        String directions;

        //Kontrollerar dörrar och sparar i directionsNESW om dom finns
        if (currentRoom.canMove(Direction.NORTH)) {
            directionsNESW.add("North");
        }
        if (currentRoom.canMove(Direction.EAST)) {
            directionsNESW.add("East");
        }
        if (currentRoom.canMove(Direction.SOUTH)) {
            directionsNESW.add("South");
        }
        if (currentRoom.canMove(Direction.WEST)) {
            directionsNESW.add("West");
        }
        //Sparar string som utgår från att det är ett håll tillgängligt
        directions = "It is a dead end, you can only go " + directionsNESW.get(0) + ".";

        //Kontrollerar om flera håll tillgängliga
        if (directionsNESW.size() > 1) {
            int y = 0;
            //Skriver över directions
            directions = "Where do you want to go? You can go ";
            //Lägger till "or", "." eller "," baserat på hur många tillgängliga dörrar finns kvar att spara i directions
            while (y < directionsNESW.size()) {
                directions += directionsNESW.get(y);
                if (y + 2 == directionsNESW.size()) {
                    directions += " or ";
                } else if (y + 1 == directionsNESW.size()) {
                    directions += ".";
                } else {
                    directions += ", ";
                }
                y++;
            }
        }
        //Returnerar den modifierade stringen
        return directions;
    }

    //Kontrollerar om dörren är låst
    private static boolean shouldMovePlayer(Room room, Player player, Direction direction) {
        //Ifall dörren är låst
        if (room.isDoorLocked(direction)) {
            System.out.print("The door is locked - ");
            //Kontrollerar om spelaren har nyckel och isåfall fråga om hen vill låsa upp dörren
            if (player.hasKey()) {
                System.out.println("You have the key, do you want to use it? (Y/N)");
                var input = INPUT.nextLine().toLowerCase();
                //Om ja lås upp dörren
                if (input.equalsIgnoreCase("y")) {
                    System.out.println("The door opens with a squeak");
                    return true;
                } else {
                    return false;
                }
            } else {
                //Om spelaren saknar nyckel, skriv ut det
                System.out.println("you don't have a key, go find it");
                return false;
            }
        }
        return true;
    }

}