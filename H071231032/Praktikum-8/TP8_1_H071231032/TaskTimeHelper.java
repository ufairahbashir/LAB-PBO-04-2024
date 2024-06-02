package TP8_1;

import java.util.Random;

public class TaskTimeHelper {
    public static int getRandomExecutionTime() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; // (0-5) + 1
    }
}