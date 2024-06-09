package TP8_1_H071231079;

import java.util.concurrent.atomic.AtomicInteger;

public class UIThread implements Runnable {
    private boolean isSuccess;
    private int executionTime;
    private static AtomicInteger elapsedTime = new AtomicInteger(0);

    @Override
    public void run() {
        executionTime = TaskTimeHelper.getRandomTime();
        try {
            if (executionTime > 4) {
                System.out.println("Request Timeout");
                isSuccess = false;
            } else {
                for (int i = 0; i < executionTime; i++) {
                    Thread.sleep(1000);
                    int elapsedSeconds = elapsedTime.incrementAndGet();
                    System.out.printf("Loading... (%ds)\n", elapsedSeconds);
                }
                isSuccess = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            isSuccess = false;
        }
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public int getExecutionTime() {
        return executionTime;
    }
}
