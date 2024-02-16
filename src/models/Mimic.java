package models;

public class Mimic extends EnemyModel{
    static Player player;

    public Mimic() {
        setMonsterRaces(MonsterRaces.MIMIC);
        setLvl(1);
        setHp(10);
        setConstitution(9);
        setStrength(7);
        setDexterity(15);
        setEnemyAC(12);
    }

    public static int enemyDied(){
        int xpDropped = 10 + player.getLvl();

        if (isAlive()){
            attack(roll(1, 20));
        }else {
            setAlive(false);
            return xpDropped;
        }

        return -1;
    }

    public static int attack(int armourClassCheckRoll){
        int totalDamage = 0;

        if (armourClassCheckRoll >= player.getPlayerAC()){
            // totalDamage = 3 through 20 damage
            totalDamage = roll(3, 6) + calculateStrModifier();

            if (armourClassCheckRoll == 20){
                totalDamage = (roll(3, 6) + calculateStrModifier()) * 2;
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
