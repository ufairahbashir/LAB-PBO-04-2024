package TP8_2_H071231079;

public class Typer extends Thread {
    private String botName;
    private StringBuilder wordsTyped;
    private double wpm;
    private double finishTime = 0.0;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wordsTyped = new StringBuilder();
        this.wpm = wpm;
        this.typeRacer = typeRacer;
    }

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String getWordsTyped() {
        return wordsTyped.toString();
    }

    public void addWordsTyped(String newWordsTyped) {
        if (wordsTyped.length() > 0) {
            wordsTyped.append(" ");
        }
        wordsTyped.append(newWordsTyped);
    }

    public double getWpm() {
        return wpm;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public double getFinishTime() {
        return finishTime;
    }

    @Override
    public void run() {
        // Mendapatkan kata-kata yang harus diketik
        String[] wordsToType = typeRacer.getWordsToType().split(" ");
        
        int typingIntervalMillis = (int) (60000 / wpm); //Menghitung waktu ketik

        // Mensimulasikan proses mengetik
        for (String word : wordsToType) {
            addWordsTyped(word);
            try {
                Thread.sleep(typingIntervalMillis);
                finishTime += typingIntervalMillis;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        addWordsTyped("selesai");
        typeRacer.addResult(this); // Menambahkan hasil ke TypeRacer
    }
}
