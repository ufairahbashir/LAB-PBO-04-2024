package TP8_2_H071231063;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private boolean running = true;
    private String wordsToType;
    private ArrayList<Typer> raceContestant = new ArrayList<Typer>();
    private ArrayList<Result> raceStanding = new ArrayList<Result>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRaceContestant() {
        return raceContestant;
    }

    private String[] wordsToTypedList = {
        "Menuju tak terbatas dan melampauinya",
        "Kehidupan adalah perjalanan yang penuh dengan lika-liku. Jadikan setiap tantangan sebagai kesempatan untuk tumbuh dan berkembang",
        "Cinta sejati adalah ketika dua jiwa saling melengkapi, memberi dukungan dan menginspirasi satu sama lain untuk menjadi yang terbaik",
        "Hidup adalah anugerah yang berharga. Nikmati setiap momen dan hargai kebahagiaan sederhana di sekitar kita",
        "Perubahan adalah satu-satunya konstanta dalam hidup. Yang bertahan adalah mereka yang dapat beradaptasi dengan fleksibilitas",
        "Kebersamaan adalah fondasi yang kuat dalam membangun hubungan yang langgeng dan bermakna",
        "Masa depan adalah milik mereka yang memiliki imajinasi, tekad, dan kerja keras untuk mewujudkan visi mereka",
        "Ketika kita berbagi dengan orang lain, kita tidak hanya mengurangi beban mereka, tetapi juga memperkaya hati kita sendiri",
        "Kesuksesan sejati adalah ketika kita mencapai tujuan kita sambil tetap mempertahankan integritas dan empati terhadap orang lain",
        "Rasa syukur adalah kunci untuk mengalami kebahagiaan yang sejati dalam hidup. Mencintai apa yang kita miliki adalah kunci kepuasan yang tak ternilai",
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(10);
        this.wordsToType = wordsToTypedList[angkaRandom];
    }

    // TODO (4)
    public void addResult(Typer typer) {
        Result result = new Result(typer.getBotName(), typer.getFinishTime());
        raceStanding.add(result);
    }

    
    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("===========================\n");

        // TODO (5)
        for (int i = 0; i < raceStanding.size(); i++) {
            System.out.printf("%d. %s = %.2fs\n",
                i + 1, raceStanding.get(i).getName(), raceStanding.get(i).getFinishTime()/1000);
        }
        System.out.println("=".repeat(41));
    }

    public void startRace() {
        // TODO (6)
        for (Typer typer : raceContestant) {
            typer.start();
        }

        new Thread(() -> {
            // TODO (7)
            while (running) {
                printTypingProgress();

                try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        
        for (Typer typer : raceContestant) {
            try {
                typer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // TODO (8)
        running = false;
        printRaceStanding();
    }

    public void printTypingProgress() {
        System.out.println("\nTyping...");
        System.out.println("---------");

        for (Typer typer : raceContestant) {
            System.out.printf("- %s\n=>  %s\n\n", typer.getBotName(), typer.getWordsTyped());
        }
    }
}