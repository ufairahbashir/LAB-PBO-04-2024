import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;
class TaskTimeHelper {
    public static int getRandomExecutionTime() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
class DataLoaderThread implements Runnable {
    private boolean isSuccess;
    private AtomicInteger time;
    public DataLoaderThread(AtomicInteger time) {
        this.time = time;
    }
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
public class TP8_1_H071231063 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            AtomicInteger totalTime = new AtomicInteger();
            int dataSuccess = 0, dataFail = 0;
            System.out.print("Enter the amount of data: ");
            int totalData = sc.nextInt();
            DataLoaderThread dataLoaderThread;
            System.out.println("Start load " + totalData + " data");
            for (int i = 1; i <= totalData; i++) {
                dataLoaderThread = new DataLoaderThread(totalTime);
                Thread thread = new Thread(dataLoaderThread);
                thread.start();
                try {
                    thread.join();
                    if (dataLoaderThread.getIsSuccess()) { 
                        dataSuccess++; 
                    } else { 
                        dataFail++; 
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nTask Finish.");
            System.out.println("Time Execution: " + totalTime + "s");
            if (dataFail == 0){
                 System.out.println("All data is successfully loaded");
            }else{
                System.out.println(dataSuccess + " data successfully loaded & " + dataFail + " data failed to load");
            }    
        }
    }
}