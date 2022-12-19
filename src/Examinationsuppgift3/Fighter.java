package Examinationsuppgift3;

abstract class Fighter {
    public void fightSequence(Player player, Monster monster){
        System.out.printf("%nYou encounter a %s!%n%s%n", monster.getMonsterType(), monster.getMonsterPicture());
        while (monster.getMonsterHealth() > 0){
            player.setPlayerHealth(monster.Attack(monster.getMonsterStrength(), player.getPlayerHealth()));
            System.out.printf("%n%s attacks and deals \u001b[31m%s\u001b[0m damage!%n%s has %s healthpoints left.",
                    monster.getMonsterType(), monster.getMonsterStrength(), player.getName(), player.getPlayerHealthString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (player.getPlayerHealth() <= 0){
                endGame();
            }
            monster.setMonsterHealth(player.Attack(player.getplayerStrength(), monster.getMonsterHealth()));
            System.out.printf("%n%s attacks and deals \u001b[31m%s\u001b[0m damage!%n%s has %s healthpoints left.",
                    player.getName(), player.getplayerStrength(), monster.getMonsterType(), monster.getMonsterHealthString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%nThe %s has been defeated!%n", monster.getMonsterType());
    }

    public int Attack (int attackerStrength, int defenderHealth){
        defenderHealth -= attackerStrength;
        return defenderHealth;
    }
    public static void endGame(){
        System.out.println("You died");
        System.exit(0);
    }
}
