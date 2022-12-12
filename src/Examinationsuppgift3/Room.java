package Examinationsuppgift3;
//Importerar Scanner

import java.util.Set;

//Skapar en Room klass
public class Room {

    //Privata variabler för rummen och en static variabel för alla rum
    private String roomDescription;
    private Set<Direction> possibleDirections;


    //Setters för alla rummen
    public Room(String roomDescription, Direction... canMove) {
        this.roomDescription = roomDescription;
        possibleDirections = Set.of(canMove);
    }

    public void doNarrative() {
        //Skriver ut rum beskrivning och väntar på input av spelare
        menuBar();
        System.out.println(roomDescription);
    }

    public boolean canMove(Direction direction) {
        return possibleDirections.contains(direction);
    }

    private void menuBar() {
        String breaks = "%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n";
        String longs = "-------------------------------------------------------------------";
        String letters = "| Health: 100 | Map: M | Potion: P |";

        System.out.printf(breaks);
        System.out.printf("%n%s%n%s%n%s%n", longs, letters, longs);
    }
}

