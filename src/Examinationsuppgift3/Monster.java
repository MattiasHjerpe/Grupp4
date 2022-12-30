package Examinationsuppgift3;

//Skapar en Monster class som ärver Fighter
public class Monster extends Fighter{
    private String monsterType, monsterPicture;
    private final int yPosition, xPosition;
    private int monsterHealth, monsterStrength, monsterStartingHealth;

    private boolean isKilled = false;

    //Konstruktor för monster, sätter monsterType och position(vilket rum)
    public Monster(String monsterType, int startYPosition, int startXPosition) {
        setMonsterType(monsterType);
        yPosition = startYPosition;
        xPosition = startXPosition;
    }

    //Method(s)
    //Monsters egna Attack metod
    @Override
    public void Attack (Player player, Monster monster){
        player.setPlayerHealth(player.getPlayerHealth() - monster.getMonsterStrength());
    }

    //Setters
    //Set monster strength
    public void setMonsterStrength(int monsterStrength) {
        this.monsterStrength = monsterStrength;
    }

    //Set monster hälsa, minimum är 0
    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
        if (this.monsterHealth < 0){
            this.monsterHealth = 0;
        }
    }

    //Set monster starthälsa
    public void setMonsterStartingHealth(int monsterHealth) {
        this.monsterStartingHealth = monsterHealth;
    }

    //Konfigurerar monstret baserat på om det är en dragon eller "standard", ie Goblin
    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
        if (monsterType.equals("Dragon")){
            int dragonHealth = 180;
            int dragonStrength = 10;
            setMonsterHealth(dragonHealth);
            setMonsterStartingHealth(dragonHealth);
            setMonsterStrength(dragonStrength);
            monsterPicture=(
                    "                \\||/\n" +
                            "                |  @___oo\n" +
                            "      /\\  /\\   / (__,,,,|\n" +
                            "     ) /^\\) ^\\/ _)\n" +
                            "     )   /^\\/   _)\n" +
                            "     )   _ /  / _)\n" +
                            " /\\  )/\\/ ||  | )_)\n" +
                            "<  >      |(,,) )__)\n" +
                            " ||      /    \\)___)\\\n" +
                            " | \\____(      )___) )___\n" +
                            "  \\______(_______;;; __;;;");
            // https://www.asciiart.eu/mythology/dragons)
        } else {
            monsterPicture = ("             ,      ,\n" +
                    "            /(.-\"\"-.)\\\n" +
                    "        |\\  \\/      \\/  /|\n" +
                    "        | \\ / =.  .= \\ / |\n" +
                    "        \\( \\   o\\/o   / )/\n" +
                    "         \\_, '-/  \\-' ,_/\n" +
                    "           /   \\__/   \\\n" +
                    "           \\ \\__/\\__/ /\n" +
                    "         ___\\ \\|--|/ /___\n" +
                    "       /`    \\      /    `\\\n" +
                    "      /       '----'       \\");
            //https://ascii.co.uk/art/goblin
            int standardMonsterHealth = 80;
            int standardMonsterStrength = 10;
            setMonsterHealth(standardMonsterHealth);
            setMonsterStartingHealth(standardMonsterHealth);
            setMonsterStrength(standardMonsterStrength);
        }
    }
    //Getters
    //Hämta styrka
    public int getMonsterStrength() {
        return monsterStrength;
    }

    //Hämta hälsa
    public int getMonsterHealth() {
        return monsterHealth;
    }

    //Hämta monsterType, dvs namnet (goblin eller dragon)
    public String getMonsterType() {
        return monsterType;
    }

    //Hämta monstrets bild
    public String getMonsterPicture() {
        return monsterPicture;
    }

    //Hämta start hälsan
    private int getMonsterStartingHealth() {
        return monsterStartingHealth;
    }

    //Returnerar en String med monstrets hälsa i rött om det är under 30% av ursprungshälsan, annars grönt
    public String getMonsterHealthString() {
        String monsterHealthString = "\u001b[32m" + getMonsterHealth() + "\u001b[0m";
        if ((double)getMonsterHealth() / getMonsterStartingHealth() < 0.3) {
            monsterHealthString = "\u001b[31m" + getMonsterHealth() + "\u001b[0m";
        }
        return monsterHealthString;
    }

    //Kollar om monstret lever
    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }
}
