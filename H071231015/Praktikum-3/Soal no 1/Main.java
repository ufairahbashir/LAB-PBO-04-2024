import java.io.IOException;
import java.util.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;
import Ninja.*;


public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        Weapon samehada = new Weapon("Samehada", 50, 100);
        Weapon kubikiribouchou = new Weapon("Kubikiribouchou", 80, 20);
        Weapon hiramekarei = new Weapon("Hiramekarei", 50, 50);
        Weapon gunbai = new Weapon("Gunbai", 10, 300);
        int menu;
        Scanner input = new Scanner(System.in);

        
        System.out.println("======================================Welcome to Ninja Battle=======================================");

        //PERULANGAN UTAMA disini
        while (true) {
            Naruto Naruto = new Naruto();
            Sasuke Sasuke = new Sasuke();
            Sakura Sakura = new Sakura();
            Kakashi Kakashi = new Kakashi();

            Ninja pick1 = Naruto;
            Ninja pick2 = Sasuke;
            int round = 1;
            while (true) {
                System.out.printf("%n%s\n", "=".repeat(100));
                System.out.print("Player 1 :\nPlease pick a ninja : \n1. Naruto\n2. Sasuke\n3. Sakura\n4. Kakashi\n= ");
                try {
                    menu = input.nextInt();
                    input.nextLine();
                    if (menu == 1 || menu == 2 || menu == 3 || menu == 4) {
                        break;
                    }
                    else{
                        System.out.println("Please input 1/2/3/4");
                    }
                } catch (Exception e) {
                    System.out.println("Error caused by " + e);
                    input.nextLine();
                }
            }
            if (menu == 1) {
                pick1 = Naruto;
                AudioFile.AudioSorted("Audio\\Naruto\\Naruto.wav");
            }
            else if (menu == 2) {
                pick1 = Sasuke;
                AudioFile.AudioSorted("Audio\\Sasuke\\Sasuke.wav");
            }
            else if (menu == 3) {
                pick1 = Sakura;
                AudioFile.AudioSorted("Audio\\Sakura\\Sakura.wav");
            }
            else if (menu == 4) {
                pick1 = Kakashi;
                AudioFile.AudioSorted("Audio\\Kakashi\\Kakashi.wav");
            }

            while (true) {
                System.out.print("Please pick a weapon : \n1. Samehada (+10 Attack)(+100 Armor)\n2. Kubikiribouchou (+80 Attack)(+20 Armor)\n3. Hiramekarei (+50 Attack)(+50 Armor)\n4. Gunbai (+10 Attack)(+300 Armor)\n= ");
                try {
                    menu = input.nextInt();
                    input.nextLine();
                    if (menu == 1 || menu == 2 || menu == 3 || menu == 4) {
                        break;
                    }
                    else{
                        System.out.println("Please input 1/2/3/4");
                    }
                } catch (Exception e) {
                    System.out.println("Error caused by " + e);
                    input.nextLine();
                }
            }
            if (menu == 1) {
                pick1.setWeapon(samehada);
            }
            else if (menu == 2) {
                pick1.setWeapon(kubikiribouchou);
            }
            else if (menu == 3) {
                pick1.setWeapon(hiramekarei);
            }
            else if (menu == 4) {
                pick1.setWeapon(gunbai);
            }


            while (true) {
                while (true) {
                    System.out.printf("%s\n", "=".repeat(100));
                    System.out.print("Player 2 :\nPlease pick a ninja : \n1. Naruto\n2. Sasuke\n3. Sakura\n4. Kakashi\n= ");
                    
                    try {
                        menu = input.nextInt();
                        input.nextLine();
                        if (menu == 1 || menu == 2 || menu == 3 || menu == 4) {
                            break;
                        }
                        else{
                            System.out.println("Please input 1/2/3/4");
                        }
                    } catch (Exception e) {
                        System.out.println("Error caused by " + e);
                        input.nextLine();
                    }
                }

                if (menu == 1) {
                    pick2 = Naruto;
                    AudioFile.AudioSorted("Audio\\Naruto\\Naruto.wav");
                }
                else if (menu == 2) {
                    pick2 = Sasuke;
                    AudioFile.AudioSorted("Audio\\Sasuke\\Sasuke.wav");
                }
                else if (menu == 3) {
                    pick2 = Sakura;
                    AudioFile.AudioSorted("Audio\\Sakura\\Sakura.wav");
                }
                else if (menu == 4) {
                    pick2 = Kakashi;
                    AudioFile.AudioSorted("Audio\\Kakashi\\Kakashi.wav");
                }

                if (pick1.getName() == pick2.getName()) {
                    System.out.printf("%s\n", "=".repeat(100));
                    System.out.println("Cannot pick the same ninja");
                }
                else{
                    break;
                }
            }
            
            while (true) {
                System.out.print("Please pick a weapon : \n1. Samehada (+10 Attack)(+100 Armor)\n2. Kubikiribouchou (+80 Attack)(+20 Armor)\n3. Hiramekarei (+50 Attack)(+50 Armor)\n4. Gunbai (+10 Attack)(+300 Armor)\n= ");
                try {
                    menu = input.nextInt();
                    input.nextLine();
                    if (menu == 1 || menu == 2 || menu == 3 || menu == 4) {
                        break;
                    }
                    else{
                        System.out.println("Please input 1/2/3/4");
                    }
                } catch (Exception e) {
                    System.out.println("Error caused by " + e);
                    input.nextLine();
                }
            }
            if (menu == 1) {
                pick2.setWeapon(samehada);
            }
            else if (menu == 2) {
                pick2.setWeapon(kubikiribouchou);
            }
            else if (menu == 3) {
                pick2.setWeapon(hiramekarei);
            }
            else if (menu == 4) {
                pick2.setWeapon(gunbai);
            }



            //   MULAI GASKAN 
            System.out.printf("%s%n", "=".repeat(100));
            System.err.println("Game start in");
            System.err.println("3");
            Thread.sleep(1000);
            System.err.println("2");
            Thread.sleep(1000);
            System.err.println("1");
            Thread.sleep(1000);
            System.out.printf("%s%n", "=".repeat(100));



            
            outerloop:
            while (true) {
                if (pick2.getHealth() <= 0 || pick1.getHealth() <= 0) {
                    if (pick2.getHealth() <= 0) {
                        System.out.printf("%s%n", "=".repeat(100));
                        System.out.println(pick1.getName() + " win !");
                        System.out.printf("%s%n", "=".repeat(100));
                    }
                    else if (pick1.getHealth() <= 0) {
                        System.out.printf("%s%n", "=".repeat(100));
                        System.out.println(pick2.getName() + " win !");
                        System.out.printf("%s%n", "=".repeat(100));
                    }
                    while (true) {
                        System.out.print("1. Play again\n2. Exit\n= ");
                        
                        try {
                            menu = input.nextInt();
                            input.nextLine();
                            if (menu == 1 || menu == 2) {
                                if (menu == 1) {
                                    break outerloop;
                                }
                                else if (menu == 2) {
                                    System.exit(0);
                                }
                            }
                            else{
                                System.out.println("Please input 1 or 2");
                            }
                        } catch (Exception e) {
                            System.out.println("Error caused by " + e);
                            input.nextLine();
                        }
                    }
                }
                else{
                    System.out.printf("%s%n", "=".repeat(100));
                    System.out.println("Round " + round);
                    round++;

                    System.out.printf("%s%n", "=".repeat(100));
                    System.out.println("Player 1 : " + pick1.getName());               
                    System.out.println("Attack: " + pick1.getAttack());
                    System.out.println("Health: " + pick1.getHealth());
                    System.out.println("Armor: " + pick1.getArmor());
                    System.out.println("Chakra: " + pick1.getChakra());
                    System.out.println();
                    System.out.println(pick1.getName() + "'s skill : ");
                    pick1.skill(pick2);
                    pick1.useWeapon();
                    Thread.sleep(2000);
                    

                    System.out.printf("\n%s%n", "=".repeat(100));
                    System.out.println("Player 2 : " + pick2.getName());
                    System.out.println("Attack: " + pick2.getAttack());
                    System.out.println("Health: " + pick2.getHealth());
                    System.out.println("Armor: " + pick2.getArmor());
                    System.out.println("Chakra: " + pick2.getChakra());
                    System.out.println();
                    System.out.println(pick2.getName() + "'s skill : ");
                    pick2.skill(pick1);
                    pick2.useWeapon();
                    Thread.sleep(2000);
                }
            }
        }
    }
}