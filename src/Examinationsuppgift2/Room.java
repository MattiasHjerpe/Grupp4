package Examinationsuppgift2;
//Importerar Scanner
import java.util.Scanner;
import java.util.ArrayList;
//Skapar en Room klass
public class Room {

    //Privata variabler för rummen och en static variabel för alla rum
    private String roomDescription, north, east, south, west, directions;
    private ArrayList<String> directionsNESW = new ArrayList<String>();
    private static String wrongWay = "You stare at the wall, there is nothing there. You turn around.";

    //Setters för alla rummen
    public void RoomFacts(String roomName, String north, String east, String south, String west, String roomDescription){
        this.roomDescription = roomDescription;
        if (north != null){
            this.north = north;
            directionsNESW.add(this.north);
        }
        if (east != null){
            this.east = east;
            directionsNESW.add(this.east);
        }
        if (south != null){
            this.south = south;
            directionsNESW.add(this.south);
        }
        if (west != null){
            this.west = west;
            directionsNESW.add(this.west);
        }
        directions = "It is a dead end, you can only go " + directionsNESW.get(0) + ".";
        if (directionsNESW.size() > 1){
        int y = 0;
        directions = "You can go ";
        while (y < directionsNESW.size()){
            directions += directionsNESW.get(y);
            if (y + 2 == directionsNESW.size()){
                directions += " or ";
            } else if (y + 1 == directionsNESW.size()){
                directions += ".";
            } else{
                directions += ", ";
            }
            y++;
        }
        }

    }

    //Getters för tillgängliga vädersträck
    String getNorth(){
        return north;
    }

    String getEast(){
        return east;
    }
    String getSouth(){
        return south;
    }
    String getWest(){
        return west;
    }

    String getDirections(){
        return directions;
    }

    String getRoomDescription(){
        return roomDescription;
    }

    //Här spelas individuella rummen
    public int[] doNarrative(int[] iy){
        //Skapar en scanner för att ta emot input
        Scanner input = new Scanner(System.in);

        //Skriver ut rum beskrivning och väntar på input av spelare
        System.out.println(roomDescription);
        System.out.println(directions);
        String direction = input.nextLine().toLowerCase();

        //Switch sats som antingen skriver ut att man gått åt fel håll eller skickar tillbaka variablerna för det nya rummet
        switch(direction) {
            case "n": case "north":
                if (getNorth() != null){
                    iy[0]--;
                }else {
                    System.out.println(wrongWay);
                }
                break;
            case "e": case "east":
                if (getEast() != null){
                    iy[1]++;
                }else {
                    System.out.println(wrongWay);
                }
                break;
            case "s": case "south":
                if (getSouth() != null){
                    iy[0]++;
                }else {
                    System.out.println(wrongWay);
                }
                break;
            case "w": case "west":
                if (getWest() != null){
                    iy[1]--;
                }else {
                    System.out.println(wrongWay);
                }
                break;
            default:
                break;
        }
        return iy;
    }
}

