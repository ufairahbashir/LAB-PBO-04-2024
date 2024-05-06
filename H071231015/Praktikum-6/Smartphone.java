import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;

class Smartphone implements Move{
    int price;
    String brand;

    @Override
    public void move() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        System.out.println(this.brand + " dengan harga Rp." + this.price + " sedang berdering");
    }
}

class Phone{
    static void enterPhone(Smartphone samsung, Smartphone iphone, Smartphone toy, Smartphone anime) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        Smartphone smartphone;
        while (true) {
            System.out.printf("%s\n", "=".repeat(Map.getLebar()));
            System.out.println("Silahkan pilih jenis Smartphone:\n1. Samsung\n2. Iphone\n3. Toy\n4. Anime\n5. Kembali");
            int menu = (int) Main.inputUserAngka("= ");
            if (menu == 1) {
                smartphone = samsung;
                smartphone.move();
                AudioFile.Audio("Audio\\ringtone3.wav");
            }
            else if (menu == 2) {
                smartphone = iphone;
                smartphone.move();
                AudioFile.Audio("Audio\\ringtone2.wav");
            }
            else if (menu == 3) {
                smartphone = toy;
                smartphone.move();
                AudioFile.Audio("Audio\\ringtone1.wav");
            }
            else if (menu == 4) {
                smartphone = anime;
                smartphone.move();
                AudioFile.Audio("Audio\\ringtone4.wav");
            }
            else if (menu == 5) {
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }
    }
}

class Samsung extends Smartphone {
    public Samsung(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }
}

class Iphone extends Smartphone {
    public Iphone(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }
}

class Toy extends Smartphone {
    public Toy(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }
}

class Anime extends Smartphone {
    public Anime(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }
}

