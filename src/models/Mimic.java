package models;

public class Mimic extends EnemyModel{

    /*
    For stats and information go to:
        https://www.dndbeyond.com/monsters/16957-mimic
     */

    public Mimic() {
        setMonsterRaces(MonsterRaces.MIMIC);
        setLvl(1);
        setHp((Die.d8(9) + 18));

        if (getHp() <= 0){
            setHp((Die.d8(9) + 18));
        }

        setConstitution(15 + 2);
        setStrength(17 + 3);
        setDexterity(12 + 1);
        setEnemyAC(12);
    }

    @Override
    public int enemyDied(Player player){
        int xpDropped = 10 + player.getLvl();

        return xpDropped;
    }

    @Override
    public int attack(int armourClassCheckRoll, Player player){
        int totalDamage = 0;

        if ((armourClassCheckRoll + calculateStrModifier()) >= player.getPlayerAC()){
            // totalDamage = 1 through 8 damage

            totalDamage = Die.d8(1);

            if (armourClassCheckRoll == 20){
                totalDamage = (Die.d8(1)) * 2;
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
