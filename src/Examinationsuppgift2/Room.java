package Examinationsuppgift2;

import java.util.Scanner;

public class Room {

    private static String roomDescription, north, east, south, west;
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

    static String getNorth(){
        return north;
    }
    static String getEast(){
        return east;
    }
    static String getSouth(){
        return south;
    }
    static String getWest(){
        return west;
    }
    static String getRoomDescription(){
        return roomDescription;
    }

    static void doNarrative(String currentRoom){
        Scanner input = new Scanner(System.in);

        System.out.println(roomDescription);

        String direction = input.nextLine();


        switch(direction) {
            case "N":
                System.out.println(north);
                break;
            case "E":
                System.out.println(east);
                break;
            case "S":
                System.out.println(south);
                break;
            case "W":
                System.out.println(west);
                break;
            default:
                // code block
        }



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

