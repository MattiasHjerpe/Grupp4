//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Examinationsuppgift3;

import java.util.Scanner;

public class DragonTreasure {
    public DragonTreasure() {
    }

    public static void main(String[] args) {
        Dungeon dungeon = createDungeon();
        playGame(dungeon);
    }

    public static Dungeon createDungeon() {
        Room room1 = new Room("Two worn statues mark the entrance to the dungeon. The room is dark but you see two doorways. You can go North or East.",
                new Door(false, Direction.NORTH),
                new Door(false, Direction.EAST));
        Room room2 = new Room("The room is filled with boxes, seems to be a storageroom. It is a dead end, you can only go South.",
                new Weapon("Sword", "Deadly af", 20),
                new Door(false, Direction.SOUTH));
        Room room3 = new Room("You move forward deeper into the dungeon. There is a dining room table in the middle of the room with several lit candles." +
                "\n Someone must have recently been here. You can go North, South or West",
                new Door(false, Direction.SOUTH),
                new Door(false, Direction.WEST),
                new Door(false, Direction.NORTH));
        Room room4 = new Room("You come across a worn down kitchen. There is a fire in the woodstove. You can go East or South.",
                new Potion("health potion", "I feel good nanananana", 100),
                new Door(false, Direction.EAST),
                new Door(false, Direction.SOUTH));
        Room room5 = new Room("Seems to be a food pantry. There is a rotten smell in the air. It is a dead end, you can only go West",
                new Key("Key", "unlocks door... what did you think?", true),
                new Door(false, Direction.WEST));
        Room room6 = new Room("There are several torches along the walls leading up to a door. You wonder whats behind the door. " +
                "\nYou can either go through the door East or go back North.",
                new Door(false, Direction.NORTH),
                new Door(true, Direction.EAST));
        Room roomD = new Room("A dragon ambushes you! Prepare to fight!",
                new Monster("Dragon", 1, 1),
                new Door(false, Direction.EAST));
        Room[][] dungeonMap = new Room[][]{{room2, room4, room5}, {room1, room3, null}, {null, room6, roomD}};
        return new Dungeon(dungeonMap, room1, 1, 0, roomD);
    }

    public static void playGame(Dungeon dungeon) {
        Scanner input = new Scanner(System.in);
        Room currentRoom = dungeon.getStart();
        System.out.println("What is you name adventurer?");
        String name = input.nextLine();
        Player player1 = new Player(name, dungeon.getStartYPosition(), dungeon.getStartXPosition(), 100, 10);
        dungeon.enterTheDungeon();

        for (String wrongWay = "You stare at the wall, there is nothing there. You turn around."; !currentRoom.equals(dungeon.getEnd()); currentRoom = dungeon.getRoom(player1.getYPosition(), player1.getXPosition())) {
            menuBar(player1, currentRoom.canMove(Direction.NORTH), currentRoom.canMove(Direction.EAST), currentRoom.canMove(Direction.SOUTH), currentRoom.canMove(Direction.WEST));
            currentRoom.doNarrative();
            if (currentRoom.hasMonster()) {
                Monster monster = currentRoom.getMonster();
                monster.fightSequence(player1, monster);
            }

            if (currentRoom.hasItem()) {
                Item item = currentRoom.getItem();
                System.out.println("You see " + String.valueOf(item) + ", do you want to pick it up? Y/N");
                String option = input.nextLine().toLowerCase();
                if (option.equals("y")) {
                    System.out.println("You picked up the " + String.valueOf(item));
                    player1.addItem(item);
                    currentRoom.removeItem();
                }
            }

            System.out.print("Where do you go: ");
            switch (input.nextLine().toLowerCase()) {
                case "n":
                case "north":
                    if (currentRoom.canMove(Direction.NORTH)) {
                        if (currentRoom.getDoor(Direction.NORTH).isLocked()) {
                            if (player1.hasKey()) {
                                currentRoom.getDoor(Direction.NORTH).unlock();
                                System.out.println("The door is locked but you have a key and open it");
                                player1.moveNorth();
                            } else {
                                System.out.println("The door is locked");
                            }
                        } else {
                            player1.moveNorth();
                        }
                    } else {
                        System.out.println(wrongWay);
                    }
                    break;
                case "e":
                case "east":
                    if (currentRoom.canMove(Direction.EAST)) {
                        if (currentRoom.getDoor(Direction.EAST).isLocked()) {
                            if (player1.hasKey()) {
                                currentRoom.getDoor(Direction.EAST).unlock();
                                System.out.println("The door is locked but you have a key and open it");
                                player1.moveEast();
                            } else {
                                System.out.println("The door is locked");
                            }
                        } else {
                            player1.moveEast();
                        }
                    } else {
                        System.out.println(wrongWay);
                    }
                    break;
                case "s":
                case "south":
                    if (currentRoom.canMove(Direction.SOUTH)) {
                        if (currentRoom.getDoor(Direction.SOUTH).isLocked()) {
                            if (player1.hasKey()) {
                                currentRoom.getDoor(Direction.SOUTH).unlock();
                                System.out.println("The door is locked but you have a key and open it");
                                player1.moveSouth();
                            } else {
                                System.out.println("The door is locked");
                            }
                        } else {
                            player1.moveSouth();
                        }
                    } else {
                        System.out.println(wrongWay);
                    }
                    break;
                case "w":
                case "west":
                    if (currentRoom.canMove(Direction.WEST)) {
                        if (currentRoom.getDoor(Direction.WEST).isLocked()) {
                            if (player1.hasKey()) {
                                currentRoom.getDoor(Direction.WEST).unlock();
                                System.out.println("The door is locked but you have a key and open it");
                                player1.moveSouth();
                            } else {
                                System.out.println("The door is locked");
                            }
                        } else {
                            player1.moveSouth();
                        }
                    } else {
                        System.out.println(wrongWay);
                    }
                    break;
                case "m":
                case "map":
                    dungeon.getDungeonMap();
            }
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
                        "           '-.||_/.-'\n");        System.out.println("You notice a door behind the treasure chest. You escaped!");
        System.out.println("Well done, " + name + "!");
        System.exit(0);
    }

    private static void menuBar(Player player, Boolean northCheck, Boolean eastCheck, Boolean southCheck, Boolean westCheck) {
        Integer health = player.getPlayerHealth();
        String healthPlayer = "\u001b[32m" + health.toString() + "\u001b[0m";
        String breaks = "%n%n";
        String shorts = "------------------------------------";
        String longs = "-------------------------------------------------------";
        String north = "\u001b[32mNorth\u001b[0m";
        String east = "\u001b[32mEast\u001b[0m";
        String south = "\u001b[32mSouth\u001b[0m";
        String west = "\u001b[32mWest\u001b[0m";
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

        if (health < 30) {
            healthPlayer = "\u001b[31m" + health.toString() + "\u001b[0m";
        }

        System.out.printf(breaks);
        System.out.printf("%n%s%n| Health: %s | Map: M | Potion: P |%n%s%n", shorts, healthPlayer, longs);
        System.out.printf("| Available Directions: | %s | %s | %s | %s |%n%s%n%n%n", north, east, south, west, longs);
    }
}
