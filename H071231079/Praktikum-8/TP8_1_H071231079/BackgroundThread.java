package TP8_1_H071231079;

import java.util.concurrent.atomic.AtomicInteger;

public class BackgroundThread implements Runnable {
    private int executionTime; // Execution time in seconds
    private AtomicInteger totalTime; // Total time counter

    public BackgroundThread(int executionTime, AtomicInteger totalTime) {
        this.executionTime = executionTime;
        this.totalTime = totalTime;
    }

    @Override
    public void run() {
        try {
            // Simulate data loading process
            Thread.sleep(executionTime * 1000);

            // Check if execution time exceeds 4 seconds
            if (executionTime > 4) {
                System.out.println("Request Timeout");
            } else {
                System.out.println("Loading... (" + executionTime + "s)");
                totalTime.addAndGet(executionTime); // Add execution time to total time counter
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
