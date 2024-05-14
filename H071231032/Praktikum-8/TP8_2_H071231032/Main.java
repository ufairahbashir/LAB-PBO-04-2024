package TP8_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TypeRacer typeRacer = new TypeRacer();
        typeRacer.setNewWordsToType();
        System.out.println("Text to type:");
        System.out.println("\"" + typeRacer.getWordsToType() + "\"");

        Typer[] typer = new Typer[3];
        typer[0] = new Typer("Bot Jamal", 80, typeRacer);  // 750ms (80 wpm)
        typer[1] = new Typer("Bot Asep", 72, typeRacer);  // 833ms (72 wpm)
        typer[2] = new Typer("Bot Anton", 70, typeRacer);  // 857ms (70 wpm)
        
        // Typer[] typer = new Typer[5];
        // typer[0] = new Typer("Bot Shick", 70, typeRacer);  // 857ms (70 wpm)
        // typer[1] = new Typer("Bot Shack", 70, typeRacer);  // 857ms (70 wpm)
        // typer[2] = new Typer("Bot Shock", 70, typeRacer);  // 857ms (70 wpm)
        // typer[3] = new Typer("Bot Jamet", 70, typeRacer);  // 857ms (70 wpm)
        // typer[4] = new Typer("Bot Johny", 70, typeRacer);  // 857ms (70 wpm)

        typeRacer.getRaceContestant().addAll(Arrays.asList(typer));
        typeRacer.startRace();
    }
}