package utils;

import java.util.Random;

public class Randomizer {
    private final static String empty = "";
    static Random rand = new Random();

    public static String generateRandomNumber() {
        return empty + rand.nextInt(1000);
    }
}
