import java.util.Scanner;

public class ExaminationsuppgiftFakultet {
    public static void main(String[] args) {
        System.out.print("Skriv in ett tal: ");
        Scanner scanner = new Scanner(System.in);
        int tal = scanner.nextInt();
        int fakultet = 1;
        for (int i = 1; i <= tal; i++) {
            fakultet = i * fakultet;
        }
        System.out.println(tal + " fakultet är: " + fakultet);
    }

}

