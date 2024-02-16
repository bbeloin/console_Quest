package models;

public class Player extends PlayerModel{
    public static int instanceCount = 0;

    public Player(){
        super();
        instanceCount++;    }

    public Player(String name, PlayerRaces playerRace, int hp, int constitution, int strength, int dexterity, int AC) {
        super(name, playerRace, hp, constitution, strength, dexterity, AC);
        instanceCount++;    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    @Override
    public int attack(int attackRoll){
        int totalDamage = 0;

        if (attackRoll >= getPlayerAC()){
            totalDamage = roll(3, 6);
            if (attackRoll == 20){
                totalDamage *= 2;
            }
        }

        return totalDamage;
    }

    @Override
    public String attackType(int roll){
        String chance = "miss";

        if (roll == 20){
            return "Critical Hit";
        } else if (roll >= getPlayerAC()) {
            return "hit";
        }else {
            return chance;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "}";
    }

}
