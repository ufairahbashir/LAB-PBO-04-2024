package livecode;
import java.util.ArrayList;
import java.util.Random;

class Typer extends Thread {
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
    public void addWordTyped(String newWordsTyped) {
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
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");
        //TODO 1
        int howLongToType = (int) (60000/wpm);

        //TODO 2
        for(String word : wordsToType){
            try {
                Thread.sleep(howLongToType);
                this.addWordTyped(word);
            } catch (Exception e) {
            }
        }
        this.addWordTyped("(selesai)");

        //TODO 3
        typeRacer.addResult(this);
    }
}

class Result {
    private String name;
    private int finishTime;

    public Result(String name, int finishTime) {
        this.name = name;
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getFinishTime() {
        return finishTime;
    }
    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }
}

class TypeRacer {
    private static String wordsToType;
    
    static ArrayList<Typer> raceContestant = new ArrayList<>();
    static ArrayList<Result> raceStanding = new ArrayList<>();
    
    public String getWordsToType() {
        return wordsToType;
    }
    public ArrayList<Typer> getRaceContestant() {
        return raceContestant;
    }

    private final static String[] wordsToTypeList = {
        "Menuju tak terbatas dan melampaui nya",
        "Kehidupan adalah perjalanan yang penuh dengan lika-liku. Jadikan setiap tantangan sebagai kesempatan untuk tumbuh dan berkembang",
        "Cinta sejati adalah ketika dua jiwa saling melengkapi, memberi dukungan dan menginspirasi satu sama lain untuk menjadi yang terbaik",
        "Hidup adalah anugerah yang berharga. Nikmati setiap momen dan hargai kebahagiaan sederhana di sekitar kita",
        "Perubahan adalah satu-satunya konstanta dalam hidup. Yang bertahan adalah mereka yang dapat beradaptasi dengan fleksibilitas",
        "Kebersamaan adalah fondasi yang kuat dalam membangun hubungan yang langgeng dan bermakna",
        "Masa depan adalah milik mereka yang memiliki imajinasi, tekad, dan kerja keras untuk mewujudkan visi mereka",
        "Ketika kita berbagi dengan orang lain, kita tidak hanya mengurangi beban mereka, tetapi juga memperkaya hati kita sendiri",
        "Kesuksesan sejati adalah ketika kita mencapai tujuan kita sambil tetap mempertahankan integritas dan empati terhadap orang lain",
        "Rasa syukur adalah kunci untuk mengalami kebahagiaan yang sejati dalam hidup. Mencintai apa yang kita miliki adalah kunci kepuasan yang tak ternilai"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        TypeRacer.wordsToType = wordsToTypeList[angkaRandom];
    }

    void addResult(Typer typer){
        int finish_time = (int) (60000/typer.getWpm())*typer.getWordsTyped().split(" ").length;
        Result res = new Result(typer.getBotName(), finish_time);
        raceStanding.add(res);
    }

    private void printRaceStanding(){
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=".repeat(100));
        // int count =1;
        // for(Result i : raceStanding){
        //     System.out.printf("%d. %s : %.2f detik", count, i.getName(), i.getFinishTime()/1000);
        //     count++;
        // }
        for (int i = 0; i < raceStanding.size(); i++){
            double finishTime = (double) (raceStanding.get(i).getFinishTime());
            double outputDetik = finishTime/1000;
            System.out.println(String.format("%d. %s = %.2f detik", (i + 1), raceStanding.get(i).getName(), outputDetik));
        }
    }

    public void startRace(){

        for(Typer i: raceContestant){
            i.start();
        }

        // while (true) {
        //     try {
        //         System.out.println();
        //         System.out.println("Typing Progress ....");
        //         System.out.println("=".repeat(100));
        //         Thread.sleep(2000);
        //         for (Typer i : raceContestant){
        //             System.out.println(i.getBotName() + " => " + i.getWordsTyped());
        //             System.out.println();
        //         }
        //     } catch (Exception e) {
        //         // TODO: handle exception
        //     }

        //     if (raceStanding.size() == raceContestant.size()) {
        //         break;
        //     }
        // }


        while (true) {
            if (raceStanding.size() != raceContestant.size()) {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("\nTyping Progress ...");
                System.out.println("=".repeat(200)+"\n");
                for (Typer j:raceContestant){
                    System.out.println(" " + j.getBotName() + " => " +j.getWordsTyped());
                }
            }
            else{
                break;
            }
        }

        this.printRaceStanding();
    }


}