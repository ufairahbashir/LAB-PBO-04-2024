package Ninja;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;

public class Kakashi extends Ninja{
    Scanner input = new Scanner(System.in);
    int menu;
    public Kakashi(){
        super("Kakashi Hatake",1000,6000, 110, 900);
    }

    public void skill(Ninja target) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            System.out.print("1. Fill chakra (+100 Chakra)\n2. Raikiri (-50 Chakra)\n3. Doton Doryuheki (+ 300 Armor)(-10 Chakra)\n= ");
            try {
                menu = input.nextInt();
                if (menu == 1) { 
                    System.out.println("Chakra filled " + "(+100)");
                    chakra+=100;
                    AudioFile.Audio("Audio\\Effect\\FIll chakra.wav");
                    break;
                }
                else if (menu == 2) {
                    chakra -= 50;
                    System.out.println("Kakashi : Raikiri");
                    AudioFile.Audio("Audio\\Kakashi\\Raikiri.wav");
                    AudioFile.Audio("Audio\\Effect\\thunder_effect.wav");
                    if (target.getArmor() >0) {
                        target.armor -= attack * (0.5);
                        target.health -= attack * (0.2);
                    }
                    else{
                        target.health -= attack * (0.5);
                    }
                    break;
                }
                else if (menu == 3) {
                    chakra -= 10;
                    System.out.println("Kakashi : Doton Doryuheki");
                    AudioFile.Audio("Audio\\Kakashi\\Doton.wav");
                    armor += 300;
                    break;
                }
                else{
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Error caused by " + e);
                input.nextLine();
            }
            
        }
    }
}

