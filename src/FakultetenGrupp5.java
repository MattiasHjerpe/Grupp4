import java.util.Scanner;
// Importerar Scanner
public class FakultetenGrupp5 {
    public static void main(String[] args) {
        System.out.print("Skriv in ett tal: ");
        //Ber användaren skriva in ett tal
        Scanner scanner = new Scanner(System.in);
        //Skapar ett object i Scanner
        int tal = scanner.nextInt(), fakultet = 1;
        //Initialiserar tal och fakultet

        while (tal < 0) {
            System.out.printf("Ogiltigt tal, vänligen skriv in ett positivt heltal%nSkriv in ett tal: ");
            tal = scanner.nextInt();
            //Om talet är mindre än 0 skrivs ett felmeddelande ut och sedan ges möjligheten att skriva in ett giltligt tal
        }
        for (int i = 1; i <= tal; i++) {
            //Loopar i till samma värde som tal
            fakultet = i * fakultet;
            //Multiplicerar i med fakulteten
        }
        System.out.printf("%d! = %d", tal, fakultet);
        //Skriver ut tal! = fakulteten
    }
}