package Examinationsuppgift3;
//Importerar Scanner

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Skapar en Room klass
public class Room {

    //Privata variabler för rummen och en static variabel för alla rum
    private String roomDescription;
    private Map<Direction, Door> doorMap;


    //Setters för alla rummen
    public Room(String roomDescription, Door... doors) {
        this.roomDescription = roomDescription;
        doorMap = new HashMap<>();
        for (Door door : doors) {
            doorMap.put(door.getDirection(), door);
        }
    }

    public void doNarrative() {
        //Skriver ut rum beskrivning och väntar på input av spelare
        menuBar();
        System.out.println(roomDescription);
    }

    public boolean canMove(Direction direction) {
        return doorMap.containsKey(direction);
    }

    private void menuBar() {
        String breaks = "%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n";
        String longs = "-------------------------------------------------------------------";
        String letters = "| Health: 100 | Map: M | Potion: P |";

        System.out.printf(breaks);
        System.out.printf("%n%s%n%s%n%s%n", longs, letters, longs);
    }
}

