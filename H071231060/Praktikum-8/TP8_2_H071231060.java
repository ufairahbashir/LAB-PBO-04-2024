import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Typer extends Thread {
    private String botName;
    private String WordTyped = "";
    private double wpm;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.typeRacer = typeRacer;
    }

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String getWordTyped() {
        return WordTyped;
    }

    public void setWordTyped(String newWordTyped) {
        this.WordTyped += newWordTyped + " ";
    }

    public double getWpm() {
        return wpm;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public TypeRacer getTypeRacer() {
        return typeRacer;
    }

    public void setTypeRacer(TypeRacer typeRacer) {
        this.typeRacer = typeRacer;
    }

    @Override
    public void run() {
        double howLongToType = (60.0 / wpm) * 1000;
        
        String[] words = typeRacer.getWordsToType().split(" ");
        long startTime = System.currentTimeMillis();
        for (String word : words) {
            try {
                Thread.sleep((long) howLongToType);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setWordTyped(word);
        }

        this.setWordTyped("(Selesai)");

        long finishTime = System.currentTimeMillis();
        int finishTimeInSeconds = (int) ((finishTime - startTime) / 1000);
        typeRacer.addResult(new Result(botName, finishTimeInSeconds));
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

    public void setName(String racerName) {
        this.name = racerName;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int racerTime) {
        this.finishTime = racerTime;
    }
}

class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> raceContestant = new ArrayList<>();
    private ArrayList<Result> raceStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRaceContestant() {
        return raceContestant;
    }

    private String[] wordToTypeList = {
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

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(10);
        wordsToType = wordToTypeList[angkaRandom];
    }

    public void addResult(Result result) {
        raceStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("========================\n");
        int position = 1;
        for (Result result : raceStanding) {
            System.out.println(position + ". " + result.getName() + " = " + result.getFinishTime() + " detik");
            position++;
        }
    }

    public void startRace() {
        for (Typer typer : raceContestant) {
            typer.start();
        }

        boolean allFinished = false;
        while (!allFinished) {
            allFinished = true;
            System.out.println("Typing Progress.......");
            System.out.println("===================");
            for (Typer typer : raceContestant) {
                System.out.println("- " + typer.getBotName() + " => " + typer.getWordTyped());
                if (!typer.getWordTyped().endsWith("(Selesai) ")) {
                    allFinished = false;
                }
            }
            System.out.println();

            if (!allFinished) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        printRaceStanding();
    }
}

public class TP8_2_H071231060 {
    public static void main(String[] args) throws InterruptedException {
        TypeRacer typeRacer = new TypeRacer();
        typeRacer.setNewWordsToType();
        System.out.println("|| Text to type ||");
        System.out.println("\"" + typeRacer.getWordsToType() + "\"");

        Typer[] typers = new Typer[3];

        typers[0] = new Typer("Bot Abel", 90, typeRacer);
        typers[1] = new Typer("Bot Muplih", 72, typeRacer);
        typers[2] = new Typer("Bot Jar", 70, typeRacer);

        typeRacer.getRaceContestant().addAll(Arrays.asList(typers));

        typeRacer.startRace();
    }
}