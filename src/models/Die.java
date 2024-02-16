package models;

import java.util.Random;

public class Die {
    private static Random random = new Random();

    public static int roll(int numDice, int diceSides) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(diceSides) + 1;
        }

        return totalRoll;
    }
}
