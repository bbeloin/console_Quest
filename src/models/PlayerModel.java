package models;

import java.util.Random;

public abstract class PlayerModel {
    private Random random = new Random();
    private String name;
    private PlayerRaces playerRace;
    private int hp, strength, speed, Dexterity, playerAC, lvl, xp;
    private static int Constitution;
    private int neededXP = 10;
    private boolean isAlive;

    public PlayerModel() {
        setName("Benjamen");
        setPlayerRace(PlayerRaces.HUMAN);
        setLvl(1);
        setHp(10);
        setConstitution(10);
        setStrength(8);
        setDexterity(12);
        setPlayerAC(12);
        setAlive(true);
    }

    public PlayerModel(String name, PlayerRaces playerRace, int hp, int constitution, int strength, int dexterity, int playerAC) {
        setName(name);
        setPlayerRace(playerRace);
        setLvl(1);
        setHp(hp);
        setConstitution(constitution);
        setStrength(strength);
        setDexterity(dexterity);
        setPlayerAC(playerAC);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerRaces getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(PlayerRaces playerRace) {
        this.playerRace = playerRace;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp <= 0){
            setAlive(false);
        } else{
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed + calculateDexModifier();
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public int getPlayerAC() {
        return playerAC;
    }

    public void setPlayerAC(int playerAC) {
        this.playerAC = playerAC;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getNeededXP() {
        return neededXP;
    }

    public void setNeededXP(int neededXP) {
        this.neededXP = neededXP;
    }


    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        if (getXp() >= getNeededXP()){
            setNeededXP(getNeededXP() + 5);
            setXp(getXp() - getNeededXP());
            this.lvl = lvl + 1;
        }else {
            this.lvl = lvl;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public static int calculateConModifier(){
        return (getConstitution() - 10) / 2;
    }

    public int calculateStrModifier(){
        return (getStrength() - 10) / 2;
    }

    public int calculateDexModifier(){
        return (getDexterity() - 10) / 2;
    }

    public abstract int attack(int attackRoll);

    public abstract String attackType(int roll);

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName()).append("{")
                .append("Name: ").append(getName())
                .append(", Race: ").append(getPlayerRace())
                .append(", Lvl: ").append(getLvl())
                .append(", HP: ").append(getHp())
                .append(", Con: ").append(getConstitution())
                .append(", Strength: ").append(getStrength())
                .append(", Dex: ").append(getDexterity())
                .append(", AC: ").append(getPlayerAC()).toString();
    }

}
