package Examinationsuppgift2;

import java.util.Scanner;

public class Room {

    private String roomDescription, north, east, south, west;
    private static String wrongWay = "You stare at the wall, there is nothing there. You turn around.";

    public void RoomFacts(String roomName, String north, String east, String south, String west, String roomDescription){
        this.roomDescription = roomDescription;
        if (north != null){
            this.north = north;
        }
        if (east != null){
            this.east = east;
        }
        if (south != null){
            this.south = south;
        }
        if (west != null){
            this.west = west;
        }

    }

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
    String getRoomDescription(){
        return roomDescription;
    }

    public int[] doNarrative(int[] iy){
        Scanner input = new Scanner(System.in);

        System.out.println(roomDescription);

        String direction = input.nextLine().toLowerCase();


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

