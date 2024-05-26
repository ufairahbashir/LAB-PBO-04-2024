package Nomor1;

class UIThread extends Thread {
    private final int numData;
    private int loadData = 0;
    private int failData = 0;
    private long startTime;

    public UIThread(int numData) {
        this.numData = numData;
    }

    public void run() {
        System.out.println("Start Load " + numData + " Data. ");
        startTime = System.currentTimeMillis();

        while (loadData + failData < numData) {
            long waktuberlalu = (System.currentTimeMillis() - startTime) / 1000 + 1;
            System.out.println("Loading .... " + waktuberlalu + "s");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long eksekusiwaktu = System.currentTimeMillis() - startTime;
        System.out.println("Berhasil!");
        System.out.println("Waktu yang dibutuhkan : " + eksekusiwaktu / 1000 + "s");

        if (failData == 0) {
            System.out.println("Semua data berhasil di muat");
        } else {
            System.out.println(loadData + "Data yang berhasil dimuat & " + failData + "Data failed to load");
        }

    }

    public synchronized void naikkanLoadData() {
        loadData++;
    }

    public synchronized void naikkanFailData() {
        failData++;
    }
}