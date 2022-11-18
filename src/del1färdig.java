
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Skriv in köpesumma: ");
        int summa = input.nextInt();
        //läser in svar och sparar köpesumman i variabeln summa

        System.out.print("Skriv in betalsumman: ");
        int kontantKvar = input.nextInt() - summa;
        //sparar summan som ska betalas i variabeln kontantKvar

        System.out.println("Totalt tillbaka: " + kontantKvar + ":-");
        //skriver ut hur mycket kunden ska få tillbaka
        System.out.println("Valörer: " + antalSedlar(kontantKvar));
        //skriver ut hur många sedlar av respektive valör som kunden ska få tillbaka genom att anropa metoden antalSedlar
    }

    static String antalSedlar(int kontantKvar) {
        //en metod som räknar ut hur många sedlar av respektive valör som kunden ska få tillbaka
        int[] valor = {1000, 500, 200, 100, 50, 20, 2, 1};
        //alla valörer
        String retur = "";
        //loopar och kollar ifall kontantKvar går att dela med valor[x]
        for (int i = 0; i < valor.length; i++) {
            if (kontantKvar == 0) {
                break;
                //kollar ifall kontantKvar är 0, isåfall behöver inte loopas mer, avbryter isåfall loopen
            } else if (kontantKvar >= valor[i]) {
                int y = kontantKvar / valor[i];
                //kollar om kontantKvar är delbart med nästa valör

                kontantKvar = kontantKvar % valor[i];
                //sparar modulus av valor[i] kontantKvar

                retur = retur + ", " + valor[i] + ":-";
                //sparar antalet valörer i retur

                if (y > 1) {
                    retur = retur + " x" + y;
                    //vid flera valörer sparas här

                }
            }
        }
        retur = retur.replaceFirst(",", " ");
        return retur.trim();
    }
