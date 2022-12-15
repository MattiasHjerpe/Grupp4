package Examinationsuppgift3;

public class Monster extends Fighter{
    private String monsterType, monsterPicture;
    private final int yPosition, xPosition;
    private int monsterHealth, monsterStrength, monsterStartingHealth;


    //Constructor for monster, sets monsterType and the monsters location
    public Monster(String monsterType, int startYPosition, int startXPosition) {
        setMonsterType(monsterType);
        yPosition = startYPosition;
        xPosition = startXPosition;
    }

    //The monsters overridden Attack method
    @Override
    public void Attack (Player player, Monster monster){
        player.setPlayerHealth(player.getPlayerHealth() - monster.getMonsterStrength());
    }

    //Setters
    public void setMonsterStrength(int monsterStrength) {
        this.monsterStrength = monsterStrength;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
        if (this.monsterHealth < 0){
            this.monsterHealth = 0;
        }
    }

    public void setMonsterStartingHealth(int monsterHealth) {
        this.monsterStartingHealth = monsterHealth;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
        if (monsterType.equals("Dragon")){
            int dragonHealth = 60;
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
            int standardMonsterHealth = 20;
            int standardMonsterStrength = 5;
            setMonsterHealth(standardMonsterHealth);
            setMonsterStartingHealth(standardMonsterHealth);
            setMonsterStrength(standardMonsterStrength);
        }
    }
    //Getters
    public int getMonsterStrength() {
        return monsterStrength;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }
    public String getMonsterType() {
        return monsterType;
    }

    public String getMonsterPicture() {
        return monsterPicture;
    }

    //Returns a string of the monsters health in either red, if its under 30% of its original health left, or green
    public String getMonsterHealthString() {
        String monsterHealthString = "\u001b[32m" + monsterHealth + "\u001b[0m";
        if ((double)monsterHealth / monsterStartingHealth < 0.3) {
            monsterHealthString = "\u001b[31m" + monsterHealth + "\u001b[0m";
        }
        return monsterHealthString;
    }

}
