package models;

public abstract class EnemyModel {
    private static MonsterRaces monsterRaces;
    private static int hp, Constitution, strength, speed, Dexterity, enemyAC, lvl;
    private static boolean isAlive;

    public static MonsterRaces getMonsterRaces() {
        return monsterRaces;
    }

    public void setMonsterRaces(MonsterRaces monsterRaces) {
        this.monsterRaces = monsterRaces;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp <= 0){
            setAlive(false);
        }else{
            this.hp = hp;
            setAlive(true);
        }
    }

    public static int getConstitution() {
        return Constitution;
    }

    public void setConstitution(int constitution) {
        this.Constitution = constitution;
    }

    public static int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        EnemyModel.speed = speed + calculateDexModifier();
    }

    public static int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public static int getEnemyAC() {
        return enemyAC;
    }

    public void setEnemyAC(int enemyAC) {
        this.enemyAC = enemyAC;
    }

    public static int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public static void setAlive(boolean alive) {
        isAlive = alive;
    }

    public abstract int enemyDied();

    public static int calculateConModifier(){
        return (getConstitution() - 10) / 2;
    }

    public static int calculateStrModifier(){
        return (getStrength() - 10) / 2;
    }

    public static int calculateDexModifier(){
        return (getDexterity() - 10) / 2;
    }

    public abstract int attack(int armourClassCheckRoll);

    @Override
    public String toString(){
        return new StringBuilder(this.getClass().getSimpleName()).append("{")
                .append("Race: ").append(getMonsterRaces())
                .append(", HP: ").append(getHp())
                .append(", Lvl: ").append(getLvl())
                .append(", Con: ").append(getConstitution())
                .append(", Strength: ").append(getStrength())
                .append(", Dex: ").append(getDexterity())
                .append(", AC: ").append(getEnemyAC()).toString();
    }
}

