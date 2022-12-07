package Examinationsuppgift2;

import java.util.Scanner;

public class Room {

    private String roomDescription, north, east, south, west;
    private static String wrongWay = "You stare at the wall, there is nothing there. You turn around.";

    public void RoomFacts(String roomName, String north, String east, String south, String west, String roomDescription){
        this.roomDescription = roomDescription;
        if (north != null){
            this.north = north;
        } else {
            this.north = wrongWay;
        }
        if (east != null){
            this.east = east;
        } else {
            this.east = wrongWay;
        }
        if (south != null){
            this.south = south;
        } else {
            this.south = wrongWay;
        }
        if (west != null){
            this.west = west;
        } else {
            this.west = wrongWay;
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
                }
                break;
            case "e": case "east":
                if (getEast() != null){
                    iy[1]++;
                }
                break;
            case "s": case "south":
                if (getSouth() != null){
                    iy[0]++;
                }
                break;
            case "w": case "west":
                if (getWest() != null){
                    iy[1]--;
                }
                break;
            default:
                break;
        }


        return iy;
    }



/*
    private int n, s, w, e;
    private String description;
    public Door(String Description, int n, int s, int w, int e); {
        this.description = Description;
    }
    public int getN(){
        return n;
    }
    public int setN(int N) {
        this.n = N;
    }
    public int getS(){
        return s;
    }
    public int setS(int S) {
        this.s = S;
    }
    public int getW(){
        return w;
    }
    public int setW(int W) {
        this.w = W;
    }
    public int getE(){
        return e;
    }
    public int setE(int E) {
        this.e = E;
    }
    */
}

