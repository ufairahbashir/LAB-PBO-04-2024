import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Scanner;

class TaskTimeHelper {
    public static int getRandomTime() {
        Random random = new Random();
        return random.nextInt(6) + 1; 
    }
}

class DataLoaderTask implements Callable<Boolean> {
    private final int taskId;

    public DataLoaderTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public Boolean call() {
        int loadTime = TaskTimeHelper.getRandomTime();
        try {
            Thread.sleep(loadTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (loadTime > 4) {
            System.out.println("Task " + taskId + " - Request Timeout");
            return false;
        }
        return true;
    }
}

public class TP8_1_H071231060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nilai data yang di Load: ");
        int numDataSources = sc.nextInt();
        sc.close();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Boolean>> futures = new ArrayList<>();

        System.out.println("Start load " + numDataSources + " data");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numDataSources; i++) {
            DataLoaderTask task = new DataLoaderTask(i + 1);
            Future<Boolean> future = executorService.submit(task);
            futures.add(future);
        }

        boolean allTasksFinished = false;
        int secondsElapsed = 0;

        while (!allTasksFinished) {
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsElapsed++;
            System.out.println("Loading..... (" + secondsElapsed + "s)");

            allTasksFinished = futures.stream().allMatch(Future::isDone);
        }

        int successfullyLoaded = 0;
        int failedToLoad = 0;

        for (Future<Boolean> future : futures) {
            try {
                if (future.get()) {
                    successfullyLoaded++;
                } else {
                    failedToLoad++;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                failedToLoad++;
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000;

        System.out.println("\nTask Finished.");
        System.out.println("Time executed: " + totalTime + "s.");

        if (failedToLoad == 0) {
            System.out.println("All data successfully loaded.");
        } else {
            System.out.println(
                    successfullyLoaded + " data successfully loaded & " + failedToLoad + " data failed to load.");
        }

        executorService.shutdown();
    }
}
