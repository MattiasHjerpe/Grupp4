package Examinationsuppgift3;

abstract class Fighter {
    // Method that handles the fighting if a player encounters a monster
    public void fightSequence(Player player, Monster monster){
        // Prints out what kind of monster it is and what it looks like
        System.out.printf("%nYou encounter a %s!%n%s%n", monster.getMonsterType(), monster.getMonsterPicture());

        // While loops that continuous until either the player or monster is dead
        while (monster.getMonsterHealth() > 0){
            // Monster attacks first, prints out the damage and remaining health of the player
            monster.Attack(player, monster);
            System.out.printf("%n%s attacks and deals \u001b[31m%s\u001b[0m damage!%n%s has %s healthpoints left.",
                    monster.getMonsterType(), monster.getMonsterStrength(), player.getName(), player.getPlayerHealthString());

            //Sleep for 0.8 seconds
            sleep();

            //Check if player is still alive, if dead then the player don't attack and instead exit the game
            if (player.getPlayerHealth() <= 0){
                endGame();
            }

            //If player is still alive, player attacks
            player.Attack(player, monster);
            System.out.printf("%n%s attacks and deals \u001b[31m%s\u001b[0m damage!%n%s has %s healthpoints left.",
                    player.getName(), player.getPlayerStrength(), monster.getMonsterType(), monster.getMonsterHealthString());

            //Sleep for 0.8 seconds
            sleep();

        }
        //Prints out victory message
        System.out.printf("%nThe %s has been defeated!%n", monster.getMonsterType());
    }

    //Sleep method, delays the program for 0.8 seconds
    public void sleep (){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //The attack method, only used by the player in the fighting class, monster have their own @override Attack()
    public void Attack (Player player, Monster monster){
        monster.setMonsterHealth(monster.getMonsterHealth() - player.getPlayerStrength());
    }

    //Ends the game in case of player death
    public static void endGame(){
        System.out.println("You died");
        System.exit(0);
    }
}
