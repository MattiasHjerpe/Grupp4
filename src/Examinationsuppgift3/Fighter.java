package Examinationsuppgift3;

public class Fighter {
    public int Attack (int attackerStrength, int defenderHealth){
        defenderHealth -= attackerStrength;
        return defenderHealth;
    }
}
