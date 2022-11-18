import java.util.Scanner;

public class Del2 {
    public static void main(String[] args) {
        System.out.print("Skriv in ett tal: ");
        Scanner scanner = new Scanner(System.in);
        int fakultet = scanner.nextInt(), summa = 1;
        //Sparar fakultetsvalet
        String talen = "";


        for (int i = 1; i <= fakultet; i++) {
            summa *= i;
            talen += i;
            if(i < fakultet){
                talen += " * ";
                //Ifall ytterligare tal ska multipliceras
            }
        }

        System.out.printf("%d! = %s = %d", fakultet, talen.trim(), summa);
    }
}
