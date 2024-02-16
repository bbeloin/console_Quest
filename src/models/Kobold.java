package models;

public class Kobold extends EnemyModel{
    Player player;

    public Kobold() {
        setMonsterRaces(MonsterRaces.KOBOLD);
        setLvl(1);
        setHp(10);
        setConstitution(9);
        setStrength(7);
        setDexterity(15);
        setEnemyAC(12);
        setAlive(true);
    }
    public int enemyDied(){
        int xpDropped = 5 + player.getLvl();

        if (isAlive()){
            attack(roll(1, 20));
        }else {
            return xpDropped;
        }

        return -1;
    }

    public int attack(int armourClassCheckRoll){
        int totalDamage = 0;

        if (armourClassCheckRoll >= player.getPlayerAC()){
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
