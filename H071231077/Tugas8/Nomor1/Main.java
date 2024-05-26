package Nomor1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        int numData = 4;

        UIThread uiThread = new UIThread(numData);
        uiThread.start();
        
        ExecutorService eksekutor = Executors.newFixedThreadPool(3);
        List<BackgroundThread> backgroundThreads = new ArrayList<>();
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < numData; i++) {
            BackgroundThread backgroundThread = new BackgroundThread(uiThread);
            backgroundThreads.add(backgroundThread);
            futures.add(eksekutor.submit(backgroundThread));
        }
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        eksekutor.shutdown();
    }

}
