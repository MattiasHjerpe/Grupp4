import java.util.Scanner;

public class del2Emelie {

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Skriv in ett heltal: ");
    int talet = input.nextInt();
    int fakultet = 1;

    int i=1;
     while(i<=talet){
         fakultet=fakultet*i;
         i++;
        }
     System.out.println(talet + "! = " + fakultet);
    }
}
