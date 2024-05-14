
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskTimeHelper {
    private static final Random random = new Random();
    public static int getRandomExecutionTime() {
        return random.nextInt(6) + 1;
    }
}

class Soal01 {
    private static int dataLoadedCount = 0;
    private static int dataFailedCount = 0;
    private static boolean isSuccess;
    private static long startTime;
    private static int data = 4;
    private static long time;

    static Runnable runnableForUIThread = new Runnable() {
        @Override
        public void run() {
            startTime = System.currentTimeMillis();
            while (true){
                time = (System.currentTimeMillis() - startTime) / 1000;
                if (time > 0){
                    System.out.println("Loading... (" + time + "s)");
                    if (dataLoadedCount + dataFailedCount == data){
                        System.out.println();
                        System.out.println("Task Finish.");
                        System.out.println("Time Execution : " + time + "s");
                        if (dataFailedCount > 0){
                            System.out.println(dataLoadedCount + " Data Succesfully loaded & " + dataFailedCount + " Data failed to load");
                        } 
                        else {
                            System.out.println("All data is successfully loaded");
                        }
                        break;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    static Runnable runnableForBackgroundThread = new Runnable() {
        public void run() {
            int executionTime = TaskTimeHelper.getRandomExecutionTime();
            // int executionTime = 2;
            try {
                if (executionTime > 4){
                    Thread.sleep(5000);
                    System.out.println("Request Timeout");
                    isSuccess = false;
                } else {
                    Thread.sleep(executionTime * 1000);
                    isSuccess = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Soal01.class){
                if (isSuccess) {
                    dataLoadedCount++;
                }
                else{
                    dataFailedCount++;
                }
            }
        }
    };

    public static void main(String[] args) {
        int backgroundThreads = 3;
        int uiThreads = 1;
        ExecutorService executorForBackgroundThread = Executors.newFixedThreadPool(backgroundThreads);
        ExecutorService executorForUIThread = Executors.newFixedThreadPool(uiThreads);

        System.out.println("Start load " + data + " Data" );

        executorForUIThread.execute(runnableForUIThread);
        for (int i = 0; i < data; i++){
            executorForBackgroundThread.execute(runnableForBackgroundThread);
        }
        executorForBackgroundThread.shutdown();
        executorForUIThread.shutdown();
    }
}
