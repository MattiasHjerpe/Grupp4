import java.util.Scanner;

public class del2Maria {
    public static void main(String[] args) {
        System.out.print("Skriv in ett tal: ");
        Scanner scanner = new Scanner(System.in);
        int tal = scanner.nextInt(), fakultet = 1;
        //Initialiserar tal och fakultet

        if (tal < 0) {
            System.out.printf("Ogiltigt tal, vänligen skriv in ett positivt heltal%nSkriv in ett tal: ");
            tal = scanner.nextInt();
        }
        for (int i = 1; i <= tal; i++) {
            fakultet = i * fakultet;
        }
        System.out.printf("%d ! = %d", tal, fakultet);
    }
//test
}