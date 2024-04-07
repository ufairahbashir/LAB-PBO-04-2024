package Ninja;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;

public class Naruto extends Ninja{
    public Naruto(){
        super("Naruto Uzumaki", 700,7000, 200, 1000);
    }
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    boolean angry = false;
    boolean sage = false ;
    int bunshin = 0;
    int menu;


    public void Basic(Ninja target) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            System.out.print("1. Fill chakra (+100 Chakra)\n2. Kagebunshin no jutsu (10 Attack per bunshin)\n3. Rasengan (-20 Chakra)\n4. Rasen Shuriken (-200 Chakra)\n= ");
            try {
                menu = input.nextInt();
                input.nextLine();
                if (menu == 1) { 
                    System.out.println("Chakra filled " + "(+100)");
                    AudioFile.Audio("Audio\\Effect\\FIll chakra.wav");
                    chakra+=100;
                    break;
                }
                else if (menu == 2) {
                    System.out.println("Naruto : Kagebunshin no jutsu");
                    AudioFile.Audio("Audio\\Naruto\\Kage bunshin\\Activating_Kage_Bunshin_no_Jutsu_(Naruto_Anime)_-_Sound_Effect_for_editing.wav");
                    while (true) {
                        System.out.print("Total bunshin : ");
                        try {
                            int tambah_bunshin = input.nextInt();
                            if (bunshin < 0) {
                                System.out.println("Invalid input");
                            }
                            else{
                                bunshin += tambah_bunshin;
                                System.out.println("Total bunshin " + bunshin);
                                chakra -= (tambah_bunshin*10);
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Error caused by " + e);
                            input.nextLine();
                        }
                        
                    }
                    if (target.getArmor() >0) {
                        target.armor -= attack * (0.1 *bunshin);
                    }
                    else{
                        target.health -= attack * (0.05* bunshin);
                    }
                    break;
                
                }
                else if (menu == 3) {
                    System.out.println("Naruto : Rasengan");
                    chakra -= 20;
                    AudioFile.Audio("Audio\\Naruto\\Rasengan\\rasengan.wav");
                    if (target.getArmor() >0) {
                        target.armor -= attack * (0.5);
                        target.health -= attack * (0.2);
                    }
                    else{
                        target.health -= attack * (0.5);
                    }
                    break;
                }
                else if (menu == 4) {
                    System.out.println("Naruto : Futon Rasen shuriken ");
                    AudioFile.AudioSorted("Audio\\Naruto\\Rasengan\\rasen shuriken.wav");
                    AudioFile.AudioSorted("Audio\\Effect\\Rasen shuriken effect.wav");
                    AudioFile.Audio("Audio\\Effect\\exploit.wav");
                    target.health -= attack;
                    chakra -= 200;
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
    public void Angry(Ninja target) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        if (chakra <= 200) {
            System.out.println("Naruto back to normal mode (Chakra = 200)");
            chakra = 200;
            angry = false;
        }
        else{
            bunshin = 0;
            int randomNumber = random.nextInt(1);
            if (randomNumber == 0) {
                chakra -= 10;
                System.out.println("Nine tails claws !!! (-10 Chakra)");
                if (target.getArmor() >0) {
                    target.armor -= attack * (0.5);
                    target.health -= attack * (0.2);
                }
                else{
                    target.health -= attack * (0.5);
                }
            }
            else if (randomNumber == 1) {
                chakra -= 150;
                System.out.println("Biju dama !!! (-150 Chakra)");
                if (target.getArmor() >0) {
                    target.armor -= attack * (3);
                    target.health -= attack;
                }
                else{
                    target.health -= attack * (3);
                }
            }
        }
    }

    public void Sage(Ninja target) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        if (chakra <= 1000) {
            sage = false;
            attack = 700;
            System.out.println("Naruto return normal mode (Attack = 700)");
        }
        else{
            while (true) {
                System.out.print("1. Odama Rasengan (-50 Chakra)\n2. Senpo: Rasen Shuriken (-200 Chakra)\n3. Senpo: Cho Odama Rasentarengan (-250 Chakra)\n= ");
                try {
                    menu = input.nextInt();
                    input.nextLine();
                    if (menu == 1 || menu == 2 || menu == 3) {
                        if (menu == 1) {
                            chakra -= 50;
                            System.out.println("Naruto : Odama Rasengan");
                            AudioFile.Audio("Audio\\Naruto\\Sage\\NarutoSage_skill1.wav");
                            if (target.getArmor() >0) {
                                target.armor -= attack;
                                target.health -= attack * (0.5);
                            }
                            else{
                                target.health -= attack;
                            }
                            break;
                        }
                        else if (menu == 2) {
                            chakra -= 200;
                            System.out.println("Naruto : Senpo: Rasen Shuriken");
                            AudioFile.Audio("Audio\\Naruto\\Sage\\xianfa.wav");
                            AudioFile.AudioSorted("Audio\\Naruto\\Rasengan\\rasen shuriken.wav");
                            AudioFile.AudioSorted("Audio\\Effect\\Rasen shuriken effect.wav");
                            AudioFile.Audio("Audio\\Effect\\exploit.wav");
                            target.health -= attack;
                            break;
                        }
                        else if (menu == 3) {
                            chakra -= 250;
                            System.out.println("Naruto : Senpo: Cho Odama Rasentarengan");
                            AudioFile.Audio("Audio\\Naruto\\Sage\\NarutoSage_skill5.wav");
                            if (target.getArmor() >0) {
                                target.armor -= attack * (2);
                                target.health -= attack;
                            }
                            else{
                                target.health -= attack * (2);
                            }
                            break;
                        }
                        
                    }
                    else{
                        System.out.println("Please input 1/2/3");
                    }
                } catch (Exception e) {
                    System.out.println("Error caused by " + e);
                    input.nextLine();
                }
            }
        }
    }



    public void skill(Ninja target) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        if (angry == true) { //Naruto chakra merah
            Angry(target);

        }
        else if (sage == true) {// Naruto sage mode
            Sage(target);
        }
        else if (chakra <= 0) {// untuk masuk ke angry
            System.out.println("Naruto is filled up by Kyubi's chakra " + "(+500 Chakra)");
            System.out.println("Grrraaahh !!!");
            AudioFile.Audio("Audio\\Naruto\\Transform\\kyubi chakra undercontrol.wav");
            angry = true;
            chakra += 500;
        }
        else if (chakra >= 1500) {
            attack = 1500;
            sage = true;
            System.out.println("Naruto entered sage mode (Attack = 1500)");
        }
        else{ //Naruto basic
            Basic(target);
        }
    }
}