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


    //Konstruktor för rum
    public Room(String roomDescription, Door... doors) {
        this.roomDescription = roomDescription;
        //Kopplar ihop rum och dörr
        doorMap = new HashMap<>();
        for (Door door : doors) {
            doorMap.put(door.getDirection(), door);
        }
    }

    /*
    public Door getDoorMap(String direction){
        if (direction.equals("North")){
            return doorMap.get(Direction.NORTH);
        } else if (direction.equals("East")) {
            return doorMap.get(Direction.EAST);
        }else if (direction.equals("South")) {
            return doorMap.get(Direction.SOUTH);
        }else{
            return doorMap.get(Direction.WEST);
        }
    }
*/
    //Konstruktor för item i rum
    public Room(String roomDescription, Item item, Door... doors) {
        this(roomDescription, doors);
        this.item = item;
    }

    //Konstruktor för monster i rum
    public Room(String roomDescription, Monster monster, Door... doors) {
        this(roomDescription, doors);
        this.monster = monster;
    }

    //Hämtar item
    public Item getItem() {
        return item;
    }

    //tar bort item från rummet
    public void removeItem() {
        item = null;
    }

    //Kontrollerar om rummet har ett item
    public boolean hasItem() {
        return item != null;
    }

    //Hämtar monstret i rummet
    public Monster getMonster() {
        return monster;
    }

    /*
    public void removeMonster() {
        monster = null;
    }
*/
    //Kontrollerar om rummet har ett monster
    public boolean hasMonster() {
        return monster != null;
    }

    //Kollar om dörren är låst
    public boolean isDoorLocked(Direction direction) {
        return doorMap.get(direction).isLocked();
    }

    //Låser upp dörren
    public void unlockDoor(Direction direction) {
        doorMap.get(direction).isLocked();
    }

    //Skriver ut rums beskrivning och väntar på input av spelare
    public void doNarrative() {
        System.out.println(roomDescription);
    }

    //Kontrollerar om spelaren kan gå åt ett visst håll
    public boolean canMove(Direction direction) {
        return doorMap.containsKey(direction);
    }
}

