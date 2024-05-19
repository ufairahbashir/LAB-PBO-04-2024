package TP8_2_H071231079;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        TypeRacer typeRacer = new TypeRacer();
        typeRacer.setNewWordsToType();
        System.out.println("Text to type:");
        System.out.println("\"" + typeRacer.getWordsToType() + "\"");

        // Membuat array of Typer
        Typer[] typers = new Typer[3];
        typers[0] = new Typer("Bot Mansur", 80, typeRacer);  
        typers[1] = new Typer("Bot ToKu", 72, typeRacer);
        typers[2] = new Typer("Bot Yukiao", 70, typeRacer);  

        // Menambahkan semua Typer ke dalam raceContestant
        Collections.addAll(typeRacer.getRaceContestant(), typers);
        
        // Memulai perlombaan mengetik
        typeRacer.startRace();
    }
}
