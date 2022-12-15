package Examinationsuppgift3;

public class Monster extends Fighter{
    private String monsterType, monsterPicture;
    private int yPosition;
    private int xPosition;
    private int monsterHealth;
    private int monsterStrength;
    private int standardMonsterHealth = 20, standardMonsterStrength = 5, dragonHealth = 60, dragonStrength = 10;

    public Monster(String monsterType, int startYPosition, int startXPosition) {
        setMonsterType(monsterType);
        yPosition = startYPosition;
        xPosition = startXPosition;
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
            setMonsterHealth(standardMonsterHealth);
            setMonsterStrength(standardMonsterStrength);
        }
    }
}
