package TP8_2_H071232080;

import java.util.Arrays;

public class MainTP8_2 {
    
    public static void main(String[] args) {
        TypeRacer typeRacer = new TypeRacer();
        typeRacer.setNewWordsToType();
        System.out.println("|| Text to Type ||");
        System.out.println("\"" + typeRacer.getWordsToType() + "\"");

        Typer[] typers = new Typer[3];

        typers[0] = new Typer("Bot mansur",  80, typeRacer);
        typers[1] = new Typer("Bot ToKu",  72, typeRacer);
        typers[2] = new Typer("Bot Yukiao",  70, typeRacer);

        typeRacer.getRaceContestan().addAll(Arrays.asList(typers));

        typeRacer.startRace();
    }
    
}
