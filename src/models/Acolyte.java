package models;

public class Acolyte extends EnemyModel{

    public Acolyte() {
        setMonsterRaces(MonsterRaces.ACOLYTE);
        setLvl(1);
        setHp(10);
        setConstitution(9);
        setStrength(7);
        setDexterity(159);
        setAC(12);
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
