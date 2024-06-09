package TP8_2_H071231079;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private boolean running = true;
    private String wordsToType;
    private ArrayList<Typer> raceContestant = new ArrayList<>();
    private ArrayList<Result> raceStanding = new ArrayList<>();

    // Getter untuk kata-kata yang harus diketik
    public String getWordsToType() {
        return wordsToType;
    }

    // Getter untuk daftar peserta lomba
    public ArrayList<Typer> getRaceContestant() {
        return raceContestant;
    }

    // Daftar kalimat yang akan digunakan dalam perlombaan
    private final String[] wordsToTypedList = {
        "Menuju tak terbatas dan melampauinya",
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

    // Mengatur kata-kata yang harus diketik dengan memilih secara acak dari daftar
    public void setNewWordsToType() {
        Random random = new Random();
        int randomIndex = random.nextInt(wordsToTypedList.length);
        this.wordsToType = wordsToTypedList[randomIndex];
    }

    // Menambahkan hasil perlombaan ke daftar hasil
    public void addResult(Typer typer) {
        Result result = new Result(typer.getBotName(), typer.getFinishTime());
        raceStanding.add(result);
    }

    // Mencetak hasil akhir perlombaan
    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================");

        for (int i = 0; i < raceStanding.size(); i++) {
            System.out.printf("%d. %s = %.2fs\n",
                i + 1, raceStanding.get(i).getName(), raceStanding.get(i).getFinishTime() / 1000);
        }
    }

    // Memulai perlombaan mengetik
    public void startRace() {
        // Thread untuk mencetak progress mengetik setiap 2 detik
        new Thread(() -> {
            while (running) {
                printTypingProgress();
                try {
                    Thread.sleep(2000); // Tidur selama 2 detik
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Menginterupsi kembali thread
                    break;
                }
            }
        }).start();
    
        // Memulai thread untuk setiap peserta lomba
        for (Typer typer : raceContestant) {
            typer.start();
        }
    
        // Menunggu semua thread peserta selesai
        for (Typer typer : raceContestant) {
            try {
                typer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        running = false; // Menandai bahwa perlombaan telah selesai
        printRaceStanding(); // Mencetak hasil akhir perlombaan
    }

    // Mencetak progress mengetik
    public void printTypingProgress() {
        System.out.println("\nTyping Progress...");
        System.out.println("==================");

        for (Typer typer : raceContestant) {
            System.out.printf("- %s => %s\n", typer.getBotName(), typer.getWordsTyped());
        }
    }
}
