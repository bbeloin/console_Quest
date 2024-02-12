package models;

import java.util.Random;

    import java.util.Random;
public abstract class EnemyModel {
        Random random = new Random();
        String name;
        MonsterRaces monsterRaces;
        int hp;
        int Constitution;
        int strength;
        int Dexterity;
        int AC;
        int lvl;
        int exp;
        boolean isAlive;


        public EnemyModel() {
            setName("Screblin(mop Boy)");
            setMonsterRaces(monsterRaces.KOBALT);
            setHp(10);
            setConstitution(9);
            setStrength(7);
            setDexterity(15);
            setAC(12);
            setLvl(1);
            setAlive(true);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

