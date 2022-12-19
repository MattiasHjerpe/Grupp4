package Examinationsuppgift3;
//Importerar Scanner

import java.util.HashMap;
import java.util.Map;

//Skapar en Room klass
public class Room {

    //Privata variabler för rummen och en static variabel för alla rum
    private String roomDescription;
    private Map<Direction, Door> doorMap;
    private Item item;
    private Monster monster;


    public Room(String roomDescription, Door... doors) {
        this.roomDescription = roomDescription;
        doorMap = new HashMap<>();
        for (Door door : doors) {
            doorMap.put(door.getDirection(), door);
        }
    }

    public Room(String roomDescription, Item item, Door... doors) {
        this(roomDescription, doors);
        this.item = item;
    }

    public Room(String roomDescription, Monster monster, Door... doors) {
        this(roomDescription, doors);
        this.monster = monster;
    }

    public Door getDoor(Direction direction) {
        return doorMap.get(direction);
    }

    public Item getItem() {
        return item;
    }

    public void removeItem() {
        item = null;
    }

    public boolean hasItem() {
        return item != null;
    }
    public Monster getMonster() {
        return monster;
    }
    public void removeMonster() {
        monster = null;
    }

    public boolean hasMonster() {
        return monster != null;
    }

    public void doNarrative() {
        //Skriver ut rum beskrivning och väntar på input av spelare
        System.out.println(roomDescription);
    }

    public boolean canMove(Direction direction) {
        return doorMap.containsKey(direction);
    }


}