package TP8_2_H071232080;

public class Typer extends Thread{

    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;


    public Typer(String botName, double wpm, TypeRacer typeRacer){
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }
    
    public void setBotName(String botName) {
        this.botName = botName;
    }
    
    public void setWpm(double wpm) {
        this.wpm = wpm;
    }
    
    //Menambahkan kata yg telah diketik oleh bot
    public void addWordTyped(String newWordsTyped){
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run(){

        String[] wordsTyper = typeRacer.getWordsToType().split(" ");
        //TODO 1
        int howLongToType = 0;
        int kecepatan = (int) (60000 / wpm);
        
        //TODO 2
        for (String word : wordsTyper){
            try {
                Thread.sleep(kecepatan);
                addWordTyped(word);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            howLongToType++;
        }

        this.addWordTyped("(selesai)");

        //TODO 3
        Result result = new Result(botName, (kecepatan * howLongToType) / 1000);
        typeRacer.addResult(result);
    }
    
    
}