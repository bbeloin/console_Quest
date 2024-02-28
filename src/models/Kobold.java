package models;

public class Kobold extends EnemyModel{
    Player player;

    /*
    For stats and information go to:
        https://www.dndbeyond.com/monsters/16939-kobold
     */

    public Kobold() {
        setMonsterRaces(MonsterRaces.KOBOLD);
        setLvl(1);

        int hpRoll = (Die.d6(2)) - 2;

        if (hpRoll == 0){
            setHp(5);
        }else {
            setHp(hpRoll);
        }

        setConstitution(9 - 1);
        setStrength(7 - 2);
        setDexterity(15 + 2);
        setEnemyAC(12);
        setAlive(true);
    }

    @Override
    public int enemyDied(){
        int xpDropped = 5 + player.getLvl();

        return xpDropped;
    }

    @Override
    public int attack(int armourClassCheckRoll){
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
    public String toString() {
        return super.toString() + "}";
    }
}
