package TP8_1_H071231079;

import java.util.Random;

public class TaskTimeHelper {
    private static final Random random = new Random();

    // Method untuk mengembalikan angka random dari 1-6
    public static int getRandomTime() {
        return random.nextInt(6) + 1;
    }
}
