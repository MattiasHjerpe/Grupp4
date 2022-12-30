package Examinationsuppgift3;

//Skapar en Fighter super class
abstract class Fighter {
    //Metod som låter spelaren "slåss" mot en monster
    public void fightSequence(Player player, Monster monster){
        if (monster.isKilled()){
            System.out.printf("There is a dead %s on the ground.%n", monster.getMonsterType());
        } else {
            //Skriver ut vad för monster det är och en bild på hur den ser ut
            System.out.printf("%nYou encounter a %s!%n%s%n", monster.getMonsterType(), monster.getMonsterPicture());

            //While loop som fortsätter till monstret eller spelaren är död
            while (monster.getMonsterHealth() > 0){
                //Monstret attackerar först, skriver ut skadan och hur mycket hälsa spelaren har kvar
                monster.Attack(player, monster);
                player.setPlayerReceivedDamage(monster.getMonsterStrength());
                System.out.printf("%n%s attacks and deals \u001b[31m%s\u001b[0m damage!%n%s has %s healthpoints left.",
                        monster.getMonsterType(), monster.getMonsterStrength(), player.getName(), player.getPlayerHealthString());

                //Pausar programmet i 0.8 sekunder
                sleep();

                //Kollar om spelaren är död, isåfall attackerar inte spelaren utan spelet avslutas
                if (player.getPlayerHealth() <= 0){
                    endGame(player);
                }

                //Spelaren attackerar, skriver ut skada och hur mycket liv monstret har kvar
                player.Attack(player, monster);
                player.setPlayerAttackDamage(player.getPlayerStrength());
                System.out.printf("%n%s attacks and deals \u001b[31m%s\u001b[0m damage!%n%s has %s healthpoints left.",
                        player.getName(), player.getPlayerStrength(), monster.getMonsterType(), monster.getMonsterHealthString());

                //Pausar programmet i 0.8 sekunder
                sleep();

            }
            //Skriver ut en vinstmeddelande
            System.out.printf("%nThe %s has been defeated!%n", monster.getMonsterType());
            monster.setKilled(true);
            player.setNumberOfMonstersFought();
        }

    }

    //Paus method, pausar programmet i 0.8 sekunder
    public void sleep (){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //Attack metod, används av spelaren, monstret har en egen @override Attack()
    public void Attack (Player player, Monster monster){
        monster.setMonsterHealth(monster.getMonsterHealth() - player.getPlayerStrength());
    }

    //Avslutar spelet om spelaren dog
    public static void endGame(Player player){
        System.out.printf("%n%nYou died%n");
        player.playerStatistics();
        System.exit(0);
    }
}
