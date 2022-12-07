package Examinationsuppgift2;

import java.util.Scanner;

public class Room {

    private String roomDescription, north, east, south, west;

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

    public String getNorth(){
        return north;
    }
    public String getEast(){
        return east;
    }
    public String getSouth(){
        return south;
    }
    public String getWest(){
        return west;
    }
    public String getRoomDescription(){
        return roomDescription;
    }

    public void doNarrative(){
        Scanner input = new Scanner(System.in);

        System.out.println(west + north + east + south + roomDescription);
        /*

        switch(direction) {
            case "N":
                System.out.println("du går north");

                break;
            case "W":
                // code block
                break;
            default:
                // code block
        }

*/

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

