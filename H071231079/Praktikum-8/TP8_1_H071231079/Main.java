package TP8_1_H071231079;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int numSources = 4; // Jumlah data sumber
        int numThreads = 3; // Jumlah thread pool

        int dataSuccess = 0, dataFail = 0; // Counters for success and failure

        // Membuat thread pool dengan ukuran numThreads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numThreads);

        // UI Thread
        System.out.println("Start load " + numSources + " Data.");

        long startTime = System.nanoTime(); // Waktu mulai memuat data

        AtomicInteger totalTime = new AtomicInteger(0); // Total execution time counter

        // Memuat data dari sumber yang berbeda menggunakan thread pool
        for (int i = 1; i <= numSources; i++) {
            UIThread uiThread = new UIThread();
            Future<?> future = executor.submit(uiThread);

            try {
                future.get();
                if (uiThread.getIsSuccess()) {
                    dataSuccess++;
                    synchronized (Main.class) {
                        totalTime.addAndGet(uiThread.getExecutionTime());
                    }
                } else {
                    dataFail++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                dataFail++;
            }
        }

        // Shutdown executor setelah selesai
        executor.shutdown();

        try {
            // Tunggu sampai semua thread selesai
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Waktu selesai memuat data
        long endTime = System.nanoTime();

        // Menampilkan hasil akhir
        System.out.println("Task Finish.");
        long totalTimeSeconds = TimeUnit.NANOSECONDS.toSeconds(endTime - startTime); // Waktu total memuat data dalam detik
        System.out.println("Time Execution : " + totalTimeSeconds + "s");

        if (dataFail == 0) {
            System.out.println("All data is successfully loaded");
        } else {
            System.out.println(dataSuccess + " data successfully loaded & " + dataFail + " data failed to load");
        }
    }
}