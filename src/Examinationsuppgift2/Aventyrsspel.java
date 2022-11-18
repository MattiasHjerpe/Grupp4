package Examinationsuppgift2;

import java.util.Scanner;

public class Aventyrsspel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        meny();
    }
    public static void meny() {
        Scanner input = new Scanner(System.in);
        System.out.printf("1. Starta nytt spel%n2. Avsluta%nVal: ");


            int menyval = input.nextInt();
            switch (menyval){
                case 1:{
                    System.out.println("Startar spelet");
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
}
