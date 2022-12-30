package Examinationsuppgift3;

import java.util.ArrayList;

//Skapar en Player klass
public class Player extends Fighter {
    private final String name;
    private int yPosition, xPosition, playerReceivedDamage, playerAttackDamage, numberOfMonstersFought, numberOfItemsPickedUp;
    private int playerHealth = 100, playerStrength = 10, numberOfPotions = 0;
    private final int playerStartingHealth;

    private boolean hasKey = false;
    //Arraylist med spelarens items
    private final ArrayList<Item> items = new ArrayList<>();

    //Constructor, skapar ny spelare
    public Player(String name, int startYPosition, int startXPosition, int playerHealth, int playerStrength) {
        this.name = name;
        yPosition = startYPosition;
        xPosition = startXPosition;
        this.playerHealth = playerHealth;
        this.playerStrength = playerStrength;
        playerStartingHealth = playerHealth;
    }

    //Method(s)
    //Lägger till saker i spelarens "ryggsäck"
    public void addItem(Item item) {
        //Lägger till i arraylist
        this.items.add(item);
        // Kollar om det nya föremålet är ett vapen, lägger isåfall till vapnets damage i playerStrength(damage)
        if (item.getClass() == Weapon.class){
            setPlayerStrength(((Weapon) item).getDamage());
        } else if (item.getClass() == Potion.class){
            numberOfPotions++;
        } else if (item.getClass() == Key.class){
            setHasKey(true);
        }
    }

    public int getNumberOfPotions(){
        return numberOfPotions;
    }

    public void setNumberOfPotions(){
        numberOfPotions = numberOfPotions-1;
    }

    public void usePotion(){
        if(getNumberOfPotions() > 0){
            for (int i = 0; i < items.size(); i++){
                if (items.get(i).getClass() == Potion.class){
                    setPlayerHealth(100);
                    System.out.println("You feel refreshed. Healthpoints fully restored.");
                    items.remove(i);
                    setNumberOfPotions();
                    break;
                }
            }
        } else {
            System.out.println("You have no potions to use.");
        }
    }

    public boolean hasKey() {
        for (Item item : items) {
            if (item.getClass().equals(Key.class)) {
                return true;
            }
        }

        return false;
    }

    //Styr spelarens rörelse
    public void moveNorth() {
        yPosition--;
    }
    public void moveEast() {
        xPosition++;
    }
    public void moveSouth() {
        yPosition++;
    }
    public void moveWest() {
        xPosition--;
    }

    //Setters
    //Set spelarens Strength
    public void setPlayerStrength (int damage){
        playerStrength += damage;
    }

    //Set spelarens hälsa, minimum 0
    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
        if (this.playerHealth < 0){
            this.playerHealth = 0;
        }
    }

    //Getters
    //Hämta spelarens namn
    public String getName() {
        return name;
    }

    //Hämta spelarens X position
    public int getXPosition() {
        return xPosition;
    }

    //Hämta spelarens Y position
    public int getYPosition() {
        return yPosition;
    }

    //Hämta spelarens hälsa
    public int getPlayerHealth() {
        return playerHealth;
    }

    //Hämta spelarens styrka
    public int getPlayerStrength() {
        return playerStrength;
    }

    //Hämta spelarens starthälsa
    private int getPlayerStartingHealth() {
        return playerStartingHealth;
    }

    //Returnerar en String med spelarens hälsa i rött om det är under 30% av ursprungshälsan, annars grönt
    public String getPlayerHealthString() {
        String playerHealthString = "\u001b[32m" + getPlayerHealth() + "\u001b[0m";
        if ((double)playerHealth / getPlayerStartingHealth() < 0.3) {
            playerHealthString = "\u001b[31m" + getPlayerHealth() + "\u001b[0m";
        }
        return playerHealthString;
    }


    //Statistik
    //Metod för att skriva ut statistiken vid slutet av spelet
    public void playerStatistics(){
        System.out.printf("%nEnd of game statistics:%nMonsters defeated: %s%nDamage given: %s%nDamage taken: %s%nNumber of items picked up: %s%n",
                getNumberOfMonstersFought(), getPlayerAttackDamage(), getPlayerReceivedDamage(), getNumberOfItemsPickedUp());
    }
    //Hämtar totala skadan
    public int getPlayerReceivedDamage() {
        return playerReceivedDamage;
    }

    //Lägger till skada i totalen
    public void setPlayerReceivedDamage(int playerReceivedDamage) {
        this.playerReceivedDamage += playerReceivedDamage;
    }

    //Hämtar totala attack skadan
    public int getPlayerAttackDamage() {
        return playerAttackDamage;
    }

    //Lägger till attack skada i totalen
    public void setPlayerAttackDamage(int playerAttackDamage) {
        this.playerAttackDamage += playerAttackDamage;
    }

    //Hämta antalet monster som spelaren slagits mot
    public int getNumberOfMonstersFought() {
        return numberOfMonstersFought;
    }

    //Lägger till dödade monster i totalen
    public void setNumberOfMonstersFought() {
        this.numberOfMonstersFought++;
    }

    //Hämtar hur många items spelaren plockat upp
    public int getNumberOfItemsPickedUp() {
        return numberOfItemsPickedUp;
    }

    //Lägger till antalet items i totalen
    public void setNumberOfItemsPickedUp() {
        this.numberOfItemsPickedUp++;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }
}
