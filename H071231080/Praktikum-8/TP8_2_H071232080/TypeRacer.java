package TP8_2_H071232080;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TypeRacer {
    
    private String wordsToType;
    private ArrayList<Typer> raceContestan = new ArrayList<>();
    private ArrayList<Result> raceStanding = new ArrayList<>();
    
    
    public String getWordsToType() {
        return wordsToType;
    }


    public ArrayList<Typer> getRaceContestan() {
        return raceContestan;
    }
    

    private String[] wordsToTypeList = {
        "Menuju tak terbatas dan melampauinya",
        "Kehidupan adalah perjalanan yang penuh dengan lika-liku. Jadikan setiap tantangan sebagai kesempatan untuk tumbuh dan berkembang",
        "Cinta sejati adalah ketika dua jiwa saling melengkapi, memberi dukungan dan menginspirasi satu sama lain untuk menjadi yang terbaik",
        "Hidup adalah anugerah yang berharga. Nikmati setiap momen dan hargai kebahagiaan sederhana di sekitar kita",
        "Perubahan adalah satu-satunya konstanta dalam hidup. Yang bertahan adalah mereka yang dapat beradaptasi dengan fleksibilitas",
        "Kebersamaan adalah fondasi yang kuat dalam membangun hubungan yang langgengdan bermakna",
        "Masa depan adalah milik mereka yang memiliki imajinasi, tekad, dan kerja keras untuk mewujudkan visi mereka",
        "Ketika kita berbagi dengan orang lain, kita tidak hanya mengurangi beban mereka, tetapi juga memperkaya hati kita sendiri",
        "Kesuksesan sejati adalah ketika kita mencapai tujuan kita sambil tetap mempertahankan integritas dan empati terhadap orang lain",
        "Rasa syukur adalah kunci untuk mengalami kebahagiaan yang sejati dalam hidup. Mencintai apa yang kita miliki adalah kunci kepuasan yang tak ternilai"
    };


    // Memilih teks secara acak dari wordToTypeList.
    public void setNewWordsToType(){
        Random random = new Random();
        int angkaRandom = random.nextInt(10);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    //TODO 4
    //Menambahkan hasil ke daftar raceStanding.
    public void addResult(Result result){
        raceStanding.add(result);
    }

    private void printRaceStanding(){
        System.out.println("\nKlasmen Akhir Type Racer");
        System.out.println("==============================\n");

        //TODO 5
        for (int i = 0; i < raceStanding.size(); i++) {
            System.out.println(String.format("%d.%s = %d detik", i + 1, raceStanding.get(i).getName(),
                    raceStanding.get(i).getFinishTime()));
        }
    }

    public void startRace(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor1 = Executors.newSingleThreadExecutor();

        //TODO 6
        for (Typer typer : raceContestan) {
            executor.execute(typer);
        }

        // TODO 7
        System.out.println("Typing Progress ... \n==================");
        boolean isAllTyperFinished = false;
        while (!isAllTyperFinished) {
            try {
                Thread.sleep(2000); // Menunggu 2 detik
                for (Typer ty : raceContestan) {
                    System.out.println(String.format("-%s\t\t=> %s", ty.getBotName(), ty.getWordsTyped()));
                }
                if (raceContestan.size() == raceStanding.size()) {
                    isAllTyperFinished = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        executor1.shutdown();
        //TODO 8
        printRaceStanding();

    }
}
