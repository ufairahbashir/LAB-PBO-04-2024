package TP8_1_H071231080;

public class BackgroundThread implements Runnable {

    @Override
    public void run() {
        
        int executionTime = TaskTimeHelper.getRandomTime();
        try {
            Thread.sleep(executionTime * 1000);
            if (executionTime > 5) {
                System.out.println("Request Timeout");
                MainTP8_1.incrementFailedLoad();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
