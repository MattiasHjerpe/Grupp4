import java.util.Scanner;

public class Del2 {
    public static void main(String[] args) {
        System.out.print("Skriv in ett tal: ");
        Scanner scanner = new Scanner(System.in);
        int fakultet = scanner.nextInt(), summa = 1;
        String talen = "";

        for (int i = 1; i <= fakultet; i++) {
            summa *= i;
            talen += " " + i;
        }

        System.out.printf("Fakultet: %d%nTal: %s%nSumma: %d", fakultet, talen.trim(), summa);
    }
}
