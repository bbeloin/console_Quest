package models;

import java.util.Random;

public abstract class PlayerModel {
    Random random = new Random();
    String name;
    PlayerRaces playerRace;
    int hp;
    int Constitution;
    int strength;
    int Dexterity;
    int AC;
    int lvl;
    int exp;
    boolean isAlive;

    public PlayerModel(){
        setName("Benjamen");
        setPlayerRace(PlayerRaces.HUMAN);
        setHp(10);
        setConstitution(10);
        setStrength(8);
        setDexterity(12);
        setAC(10);
        setLvl(1);
        setAlive(true);
    }

    public PlayerModel(String name, PlayerRaces playerRace, int hp, int constitution, int strength, int dexterity, int AC,boolean isAlive) {
        setName(name);
        setPlayerRace(playerRace);
        setHp(hp);
        setConstitution(constitution);
        setStrength(strength);
        setDexterity(dexterity);
        setAC(AC);
        setLvl(1);
        setAlive(isAlive);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerRace(PlayerRaces playerRace) {
        this.playerRace = playerRace;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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
    public abstract String toString();

}
