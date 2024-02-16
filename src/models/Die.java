package models;

import java.util.Random;

public class Die {
    private static Random random = new Random();

    public static int d4(int numDice) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(4) + 1;
        }

        return totalRoll;
    }

    public static int d6(int numDice) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(6) + 1;
        }

        return totalRoll;
    }

    public static int d8(int numDice) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(8) + 1;
        }

        return totalRoll;
    }

    public static int d10(int numDice) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(10) + 1;
        }

        return totalRoll;
    }

    public static int d12(int numDice) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(12) + 1;
        }

        return totalRoll;
    }

    public static int d20(int numDice) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(20) + 1;
        }

        return totalRoll;
    }

}
