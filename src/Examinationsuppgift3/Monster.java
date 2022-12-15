package Examinationsuppgift3;

public class Monster extends Fighter{
    private String monsterType, monsterPicture;
    private int yPosition;
    private int xPosition;
    private int monsterHealth, monsterStrength;
    private int monsterStartingHealth;
    private int standardMonsterHealth = 20, standardMonsterStrength = 5, dragonHealth = 60, dragonStrength = 10;

    public Monster(String monsterType, int startYPosition, int startXPosition) {
        setMonsterType(monsterType);
        yPosition = startYPosition;
        xPosition = startXPosition;
    }

    @Override
    public void Attack (Player player, Monster monster){
        player.setPlayerHealth(player.getPlayerHealth() - monster.getMonsterStrength());
    }

    public int getMonsterStrength() {
        return monsterStrength;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

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

    public int getMonsterStartingHealth() {
        return monsterStartingHealth;
    }

    public String getMonsterHealthString() {
        String monsterHealthString = "\u001b[32m" + monsterHealth + "\u001b[0m";
        if ((double)monsterHealth / monsterStartingHealth < 0.3) {
            monsterHealthString = "\u001b[31m" + monsterHealth + "\u001b[0m";
        }
        return monsterHealthString;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public String getMonsterPicture() {
        return monsterPicture;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
        if (monsterType.equals("Dragon")){
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
            setMonsterHealth(standardMonsterHealth);
            setMonsterStartingHealth(standardMonsterHealth);
            setMonsterStrength(standardMonsterStrength);
        }
    }


}
