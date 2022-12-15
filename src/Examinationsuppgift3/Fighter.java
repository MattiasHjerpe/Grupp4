package Examinationsuppgift3;

public class Fighter {
    public int Attack (int attackerStrength, int defenderHealth){
        defenderHealth -= attackerStrength;
        return defenderHealth;
    }

    public int fightSequence(Player player, Monster monster, String playerName){
        while (monster.getMonsterHealth() > 0){
            System.out.printf("%n%s attacks and deals %s damage!",monster.getMonsterType(), monster.getMonsterStrength());
            player.setPlayerHealth(monster.Attack(monster.getMonsterStrength(), player.getPlayerHealth()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (player.getPlayerHealth() < 0){
                endGame();
            }
            System.out.printf("%n%s attacks and deals %s damage!", playerName, player.getplayerStrength());
            monster.setMonsterHealth(player.Attack(player.getplayerStrength(), monster.getMonsterHealth()));
            System.out.printf("%n%s has %s healthpoints left.", monster.getMonsterType(), monster.getMonsterHealth());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%nThe %s has been defeated", monster.getMonsterType());
        return player.getPlayerHealth();
    }
    public static void endGame(){
        System.out.println("You died");
        System.exit(0);
    }
}
