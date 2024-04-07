package Ninja;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;

public class Sasuke extends Ninja{
    Scanner input = new Scanner(System.in);
    int menu;

    public Sasuke(){
        super("Sasuke Uchiha",900,7000, 150, 1000);
    }

    public void skill(Ninja target) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            System.out.print("1. Fill chakra (+100 Chakra)\n2. Chidori (-20 Chakra)\n3. Katon gokakyu (-15 Chakra)\n= ");
            try {
                menu = input.nextInt();
                if (menu == 1) { 
                    System.out.println("Chakra filled " + "(+100)");
                    chakra+=100;
                    AudioFile.Audio("Audio\\Effect\\FIll chakra.wav");
                    break;
                }
                else if (menu == 2) {
                    System.out.println("Sasuke : Chidori");
                    chakra -= 20;
                    if (target.getArmor() >0) {
                        target.armor -= attack * (0.5);
                        target.health -= attack * (0.2);
                    }
                    else{
                        target.health -= attack * (0.5);
                    }

                    AudioFile.Audio("Audio\\Sasuke\\Chidori\\chidori.wav");
                    AudioFile.Audio("Audio\\Effect\\chidori effect.wav");
                    AudioFile.Audio("Audio\\Effect\\chidori effect.wav");
                    break;
                }
                else if (menu == 3) {
                    System.out.println("Sasuke : Katon gokakyu no jutsu");
                    chakra -= 15;
                    if (target.getArmor() >0) {
                        target.armor -= attack * (0.5);
                        target.health -= attack * (0.2);
                    }
                    else{
                        target.health -= attack * (0.5);
                    }
                    AudioFile.AudioSorted("Audio\\Sasuke\\Sasuke_Katon_Goukakyuu.wav");
                    AudioFile.Audio("Audio\\Effect\\goukakyu effect.wav");
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