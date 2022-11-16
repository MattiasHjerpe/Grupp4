import java.util.Scanner;

public class Main {
    static String sedelMetod(String retur, int kontantKvar){
        int[] delar = {1000, 500, 200, 100, 50, 20, 2, 1};     //Alla valörer

        //Loopar och kollar ifall kontantKvar går att dela med delar[x]
        for (int i = 0; i < 8; i++){
            if(kontantKvar == 0) {
                break;
                //Kollar ifall kontantKvar är 0, isåfall behöver inte loopas mer, avbryter isåfall loopen
            } else if(kontantKvar < delar[i]){
                continue;
                //Kollar om kontantKvar är delbart med nästa valör
            } else{
                int y = kontantKvar / delar[i];
                //Sparar antalet valörer från delar[i]
                kontantKvar = kontantKvar % delar[i];
                //Sparar modulus av delar[i] kontantKvar
                retur = retur + ", " + delar[i] + ":-";
                if(y > 1){
                    retur = retur + " x" + y;
                }
            }
        }
        retur = retur.replaceFirst(",", " ");
        return retur.trim();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Skriv in kostnaden: ");
        int summa = input.nextInt();

        System.out.print("Skriv in betalsumman: ");
        int kontantKvar = input.nextInt() - summa;    //Sparar summan som ska betalas

        System.out.println("Totalt tillbaka: " + kontantKvar + ":-");
        System.out.println("Valörer: " + sedelMetod("", kontantKvar));
    }
}
