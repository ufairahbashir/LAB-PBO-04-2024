package TP8_1;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            AtomicInteger totalTime = new AtomicInteger();
            int dataSuccess = 0, dataFail = 0;

            System.out.print("\nEnter the amount of data: ");
            int totalData = sc.nextInt();
            
            DataLoaderThread dataLoaderThread; // Background Thread Pool

            // Load data from different sources
            System.out.println("=".repeat(60));
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
            // Done
            System.out.println("\nTask Completed.\nTime Execution: " + totalTime + "s");

            if (dataFail == 0) System.out.println("All data is successfully loaded");
            else System.out.println(dataSuccess + " data successfully loaded & " + dataFail + " data failed to load");
            System.out.println("=".repeat(60) + "\n");
        }
    }
}