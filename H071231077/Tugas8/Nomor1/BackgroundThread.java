package Nomor1;

import java.util.concurrent.Future;

class BackgroundThread implements Runnable {
    private final UIThread uiThread;
    public Future<?> future;

    public BackgroundThread(UIThread uiThread) {
        this.uiThread = uiThread;
    }

    public void run() {
        int eksekusiwaktu = TaskTimeHelper.getRandomExecutionTime();

        try {

            Thread.sleep(eksekusiwaktu * 1000L);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (eksekusiwaktu > 4) {
            System.out.println("Request Timeout");
            uiThread.naikkanFailData();
        } else {
            uiThread.naikkanLoadData();
        }

    }
}
