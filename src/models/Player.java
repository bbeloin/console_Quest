package models;

public class Player extends PlayerModel{

    public Player(){
        super();
    }

    public Player(String name, PlayerRaces playerRace, int hp, int constitution, int strength, int dexterity, int AC) {
        super(name, playerRace, hp, constitution, strength, dexterity, AC);
    }

    @Override
    public int attack(int attackRoll){
        int totalDamage = 0;

        if (attackRoll >= getAC()){
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
        } else if (roll >= getAC()) {
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
