package models;

public abstract class PlayerModel {
    private String name;
    private PlayerRaces playerRace;
    private int hp, strength, playerAC, lvl, xp, neededXP = 10;
    private static int Constitution, speed, Dexterity;
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

    public PlayerModel(String name, PlayerRaces playerRace, int hp, int constitution, int strength, int dexterity, int speed, int playerAC) {
        setName(name);
        setPlayerRace(playerRace);
        setLvl(1);
        setHp(hp);
        setConstitution(constitution);
        setStrength(strength);
        setDexterity(dexterity);
        setSpeed(speed);
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
            this.hp = hp;
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

    public static int calculateConModifier(){
        return (getConstitution() - 10) / 2;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int calculateStrModifier(){
        return (getStrength() - 10) / 2;
    }

    public int getSpeed() {
        return speed;
    }

    public static int setSpeed(int passedInSpeed) {
        speed = passedInSpeed + calculateDexModifier();
        return speed;
    }

    public static int getDexterity() {
        return Dexterity;
    }

    public static int calculateDexModifier(){
        return (getDexterity() - 10) / 2;
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

    public abstract int attack(int attackRoll, EnemyModel enemy);

    public abstract String attackType(int attackRoll);

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName()).append("{")
                .append("Name: ").append(getName())
                .append(", Race: ").append(getPlayerRace())
                .append(", Lvl: ").append(getLvl())
                .append(", HP: ").append(getHp())
                .append(", AC: ").append(getPlayerAC()).toString();
    }

}
