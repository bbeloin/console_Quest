package models;

public class Mimic extends EnemyModel{
    static Player player;

    /*
    For stats and information go to:
        https://www.dndbeyond.com/monsters/16957-mimic
     */

    public Mimic() {
        setMonsterRaces(MonsterRaces.MIMIC);
        setLvl(1);
        setHp((Die.roll(9, 8) + 18));
        setConstitution(15 + 2);
        setStrength(17 + 3);
        setDexterity(12 + 1);
        setEnemyAC(12);
    }

    public static int enemyDied(){
        int xpDropped = 10 + player.getLvl();

        if (isAlive()){
            attack(Die.roll(1, 20));
        }else {
            setAlive(false);
            return xpDropped;
        }

        return -1;
    }

    public static int attack(int armourClassCheckRoll){
        int totalDamage = 0;

        if ((armourClassCheckRoll + calculateStrModifier()) >= player.getPlayerAC()){
            // totalDamage = 1 through 8 damage

            totalDamage = Die.roll(1, 8);

            if (armourClassCheckRoll == 20){
                totalDamage = (Die.roll(1, 8)) * 2;
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
