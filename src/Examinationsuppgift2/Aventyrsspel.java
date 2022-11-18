package Examinationsuppgift2;

import java.util.Scanner;
import java.io.IOException;

public class Aventyrsspel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        meny();
    }
    private static void meny() {
        Scanner input = new Scanner(System.in);
        System.out.printf("1. Starta nytt spel%n2. Avsluta%nVal: ");
            int menyval = input.nextInt();
            switch (menyval){
                case 1:{
                    System.out.println("Startar spelet");
                    setupGame();
                    break;
                }
                case 2:{
                    System.out.println("Avslutar spelet");
                    break;
                }
                default:{
                    System.out.printf("Vänligen mata in 1 eller 2%n");
                }
            }
    }
    private static void setupGame() {
        }


}
