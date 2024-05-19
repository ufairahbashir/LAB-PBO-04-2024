package TP8_1_H071231080;

public class UiThread {
    
    //Pemuatan data telah dimulai
    public void startLoading(int numSources) {
        System.out.println("Start load " + numSources + " Data.");
    }

    //mencetak pesan pembaruan waktu setiap detik selama pemuatan.
    public void updateLoading(int seconds) {
        System.out.println("Loading... (" + seconds + "s)");
    }

    //mencetak pesan ketika semua tugas telah selesai.
    public void taskFinish(int totalTime, int success, int failed) {
        if (failed > 0) {
            System.out.println("Task Finish.");
            System.out.println("Time Execution: " + totalTime + "s");
            System.out.println(success + " Data Successfully Loaded & " + failed + " Data failed to load.");
        } else {
            System.out.println("Task Finish.");
            System.out.println("Time Execution: " + totalTime + "s");
            System.out.println("All data is successfully loaded");
        }
    }
}
