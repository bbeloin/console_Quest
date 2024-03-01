package models;

public class Kobold extends EnemyModel{

    /*
    For stats and information go to:
        https://www.dndbeyond.com/monsters/16939-kobold
     */

    public Kobold() {
        setMonsterRaces(MonsterRaces.KOBOLD);
        setLvl(1);

        int hpRoll = (Die.d6(2));

        if (getHp() <= 0){
            setHp(hpRoll);
        }

        setConstitution(9 - 1);
        setStrength(7 - 2);
        setDexterity(15 + 2);
        setEnemyAC(12);
        setAlive(true);
    }

    @Override
    public int enemyDied(Player player){
        int xpDropped = 5 + player.getLvl();

        return xpDropped;
    }

    @Override
    public int attack(int armourClassCheckRoll, Player player){
        int totalDamage = 0;

        if ((armourClassCheckRoll + calculateStrModifier()) >= player.getPlayerAC()){
            totalDamage = Die.d6(3);
            if (armourClassCheckRoll == 20){
                totalDamage = (Die.d6(3)) * 2;
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
