package models;

public class Enemy extends EnemyModel{

    public Enemy() {
        setMonsterRaces(MonsterRaces.MIMIC);
        setLvl(1);
        setHp(10);
        setConstitution(9);
        setStrength(7);
        setDexterity(15);
        setEnemyAC(12);
    }

    public int attack(int attackRoll){
        int totalDamage = 0;

        if (attackRoll >= getEnemyAC()){
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
        } else if (roll >= getEnemyAC()) {
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
