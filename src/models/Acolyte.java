package models;

public class Acolyte extends EnemyModel{

    Player player;

    /*
    For stats and information go to:
        https://www.dndbeyond.com/monsters/16763-acolyte
     */

    public Acolyte() {
        setMonsterRaces(MonsterRaces.ACOLYTE);
        setLvl(1);
        setHp(Die.roll(2, 8));
        setConstitution(10);
        setStrength(10);
        setDexterity(10);
        setEnemyAC(10);
    }

    public int enemyDied(){
        int xpDropped = 7 + player.getLvl();

        if (isAlive()){
            attack(Die.roll(1, 20));
        }else {
            return xpDropped;
        }

        return -1;
    }

    public int attack(int armourClassCheckRoll){
        int totalDamage = 0;

        if ((armourClassCheckRoll + 2 + calculateStrModifier()) >= player.getPlayerAC()){
            totalDamage = Die.roll(1, 4);
            if (armourClassCheckRoll == 20){
                totalDamage = (Die.roll(1, 4)) * 2;
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
