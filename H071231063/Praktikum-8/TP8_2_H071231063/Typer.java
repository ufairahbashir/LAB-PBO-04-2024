package TP8_2_H071231063;
public class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private double finishTime = 0.0;

    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wordsTyped = "";
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
        return wordsTyped;
    }

    public void addWordsType(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
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
        String[] wordsToType = typeRacer.getWordsToType().split(" ");
        // TODO (1)
        int howLongToType = (int) (60000 / wpm);

        // TODO (2)
        for (String word : wordsToType) {
            addWordsType(word);
            try {
                Thread.sleep(howLongToType);
                finishTime += howLongToType;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.addWordsType("selesai");

        // TODO (3)
        typeRacer.addResult(this);
    }
}