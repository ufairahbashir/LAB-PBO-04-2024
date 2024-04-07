package Ninja;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;

public class Sakura extends Ninja{
    Scanner input = new Scanner(System.in);
    int menu;
    public Sakura(){
        super("Sakura Haruno",600,5000, 90, 600);
    }
    public void skill(Ninja target) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            System.out.print("1. Fill chakra (+100 Chakra)\n2. Shannaro (-20 Chakra)\n3. Heal jutsu (-50 Chakra)\n= ");
            try {
                menu = input.nextInt();
                if (menu == 1) { 
                    System.out.println("Chakra filled " + "(+100 Chakra)");
                    chakra+=100;
                    AudioFile.Audio("Audio\\Effect\\FIll chakra.wav");
                    break;
                }
                else if (menu == 2) {
                    chakra -= 20;
                    System.out.println("Sakura : Shannaroo !!!");
                    target.health -= attack;
                    break;
                }
                else if (menu == 3) {
                    chakra -= 50;
                    if (health <= 1000) {
                        System.out.println("Health++ " + "(+500 Health)(-50 Chakra)");
                        health += 500;
                        break;
                    }
                    else{
                        System.out.println("Health++ " + "(+200 Health)(-50 Chakra)");
                        health += 200;
                        break;
                    }
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