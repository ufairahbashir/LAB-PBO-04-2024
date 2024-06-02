package TP8_1;

import java.util.concurrent.atomic.AtomicInteger;

public class DataLoaderThread implements Runnable {
    private boolean isSuccess;
    private AtomicInteger time;

    public DataLoaderThread(AtomicInteger time) {
        this.time = time;
    }

    @Override
    public void run() {
        int executionTime = TaskTimeHelper.getRandomExecutionTime();
        try {
            if (executionTime > 4) {
                System.out.println("Request Timeout");
                this.isSuccess = false;
            } else {
                for (int i = 0; i < executionTime; i++) {
                    Thread.sleep(1000);
                    this.time.incrementAndGet();
                    System.out.printf("Loading... (%ds)\n", this.time.get());
                    this.isSuccess = true;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }
}