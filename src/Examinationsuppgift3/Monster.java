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

    //Method(s)
    //The monsters overridden Attack method
    @Override
    public void Attack (Player player, Monster monster){
        player.setPlayerHealth(player.getPlayerHealth() - monster.getMonsterStrength());
    }

    //Setters
    //Sets monster strength(damage)
    public void setMonsterStrength(int monsterStrength) {
        this.monsterStrength = monsterStrength;
    }

    //Sets monster health, minimum is zero
    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
        if (this.monsterHealth < 0){
            this.monsterHealth = 0;
        }
    }

    //Sets the monsters starting health, used to calculate percentage left getMonsterHealthString()
    public void setMonsterStartingHealth(int monsterHealth) {
        this.monsterStartingHealth = monsterHealth;
    }

    //Configures the monster based on what type it is, dragon or "standard", ie Goblin
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
    //Gets strength
    public int getMonsterStrength() {
        return monsterStrength;
    }

    //Gets health
    public int getMonsterHealth() {
        return monsterHealth;
    }

    //Gets monsterType, ie its name(goblin or dragon)
    public String getMonsterType() {
        return monsterType;
    }

    //Gets the picture, used in fightSequence()
    public String getMonsterPicture() {
        return monsterPicture;
    }

    //Gets starting health, used by getMonsterHealthString()
    private int getMonsterStartingHealth() {
        return monsterStartingHealth;
    }

    //Returns a string of the monsters health in either red, if its under 30% of its original health left, or green
    public String getMonsterHealthString() {
        String monsterHealthString = "\u001b[32m" + getMonsterHealth() + "\u001b[0m";
        if ((double)getMonsterHealth() / getMonsterStartingHealth() < 0.3) {
            monsterHealthString = "\u001b[31m" + getMonsterHealth() + "\u001b[0m";
        }
        return monsterHealthString;
    }
}
