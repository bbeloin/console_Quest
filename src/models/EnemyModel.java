package models;

import java.util.Random;

public abstract class EnemyModel {
    private Random random = new Random();
    private MonsterRaces monsterRaces;
    private int hp, Constitution, strength, Dexterity, AC, lvl;
    private boolean isAlive;

    public MonsterRaces getMonsterRaces() {
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
        } else if (hp > 100) {
            this.hp = hp;
        }else{
            setAlive(true);
        }
    }

    public int getConstitution() {
        return Constitution;
    }

    public void setConstitution(int constitution) {
        this.Constitution = constitution;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int roll(int numDice, int diceSides) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(diceSides) + 1;
        }
        return totalRoll;
    }

    public abstract int attack(int attackRoll);

    public abstract String attackType(int roll);

    @Override
    public String toString(){
        return new StringBuilder(this.getClass().getSimpleName()).append("{")
                .append("Race: ").append(getMonsterRaces())
                .append(", HP: ").append(getHp())
                .append(", Lvl: ").append(getLvl())
                .append(", Con: ").append(getConstitution())
                .append(", Strength: ").append(getStrength())
                .append(", Dex: ").append(getDexterity())
                .append(", AC: ").append(getAC()).toString();
    }
}

