package Examinationsuppgift2;

import java.util.Scanner;


public class Dungeon {
    //Metod för uppstarten av spelet, frågar spelaren vad den vill göra
    public void enterTheDungeon(){
        Scanner input = new Scanner(System.in);

        //Start adventure
        System.out.println("You stand in front of the Dungeon. Do you want to enter? Y/N");
        String option = input.nextLine().toLowerCase();
        if (option.equals("n")){
            System.out.println("You turn around and bravely run away.");
            System.exit(0);
        }
        System.out.println("You enter the Dungeon. There is a loud rumble and the opening collapses behind you");
    }

    //Här spelas spelet, metoden tar med sig objekten room1-6
    public void playGame(Room room1, Room room2, Room room3, Room room4, Room room5, Room room6){
        Scanner input = new Scanner(System.in);

        //Skapar en karta över dungeon
        String[][] dungeonMap = { {"Room2", "Room4", "Room5"}, {"Room1", "Room3", null}, {null, "Room6", "RoomD"} };
        //Sparar var spelaren startar
        String currentRoom = dungeonMap[1][0];
        //Koordinaterna för nuvarande rummet
        int[] iy = {1, 0};

        //Create a new player
        System.out.println("What is you name adventurer?");
        String name = input.nextLine();
        Player player1 = new Player();
        player1.createPlayer(name);


        //Kör metoden som startar igång spelet utanför dungeon
        enterTheDungeon();

        //Sålänge inte spelaren nått sista rummet, RoomD, så går spelaren mellan rum i Switch satsen
        while (!currentRoom.equals("RoomD")){
            currentRoom = dungeonMap[iy[0]][iy[1]];
            switch(currentRoom) {
                case "Room1":
                    room1.doNarrative(iy);
                    break;
                case "Room2":
                        room2.doNarrative(iy);
                    break;
                case "Room3":
                        room3.doNarrative(iy);
                    break;
                case "Room4":
                        room4.doNarrative(iy);
                    break;
                case "Room5":
                        room5.doNarrative(iy);
                    break;
                case "Room6":
                        room6.doNarrative(iy);
                    break;
                default:
                    break;
            }
        }

        //Skapar ett slumpat nummer mellan 1 och 3
        int secretNumber = 1 + (int)(Math.random() * 3);
        if(secretNumber == 2){
            System.out.println("A dragon ambushes you. Sadly the programmer have not coded in any weapons for you and you are no match for the dragon...");
            System.out.println("                \\||/\n" +
                    "                |  @___oo\n" +
                    "      /\\  /\\   / (__,,,,|\n" +
                    "     ) /^\\) ^\\/ _)\n" +
                    "     )   /^\\/   _)\n" +
                    "     )   _ /  / _)\n" +
                    " /\\  )/\\/ ||  | )_)\n" +
                    "<  >      |(,,) )__)\n" +
                    " ||      /    \\)___)\\\n" +
                    " | \\____(      )___) )___\n" +
                    "  \\______(_______;;; __;;;");
        } else{
            System.out.println("You found a treasure!");
            System.out.println(
                    "                  _.--.\n"+
                            "              _.-'_:-'||\n"+
                            "          _.-'_.-::::'||\n"+
                            "     _.-:'_.-::::::'  ||\n"+
                            "   .'`-.-:::::::'     ||\n"+
                            "  /.'`;|:::::::'      ||_\n"+
                            " ||   ||::::::'      _.;._'-._\n"+
                            " ||   ||:::::'   _.-!oo @.!-._'-.\n"+
                            " \'.  ||:::::.-!() oo @!()@.-'_.||\n"+
                            "   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"+
                            "     `>'-.!@%()@'@_%-'_.-o _.|'||\n"+
                            "      ||-._'-.@.-'_.-' _.-o  |'||\n"+
                            "      ||=[ '-._.-\\U/.-'    o |'||\n"+
                            "      || '-.]=|| |'|      o  |'||\n"+
                            "      ||      || |'|        _| ';\n"+
                            "      ||      || |'|    _.-'_.-'\n"+
                            "      |'-._   || |'|_.-'_.-'\n"+
                            "      '-._'-.|| |' `_.-'\n"+
                            "           '-.||_/.-'\n");
            System.out.println("You notice a door behind the treasure chest. You escaped!");
        }


    }
}
