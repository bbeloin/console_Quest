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
        setHp(Die.d8(2));
        setConstitution(10);
        setStrength(10);
        setDexterity(10);
        setEnemyAC(10);
    }

    @Override
    public int enemyDied(){
        int xpDropped = 7 + player.getLvl();

        return xpDropped;
    }

    @Override
    public int attack(int armourClassCheckRoll){
        int totalDamage = 0;

        if ((armourClassCheckRoll + 2 + calculateStrModifier()) >= player.getPlayerAC()){
            totalDamage = Die.d4(1);
            if (armourClassCheckRoll == 20){
                totalDamage = (Die.d4(1)) * 2;
            }
        }

        return totalDamage;
    }

    @Override
    public String toString() {
        return super.toString() + "}";
    }
}
