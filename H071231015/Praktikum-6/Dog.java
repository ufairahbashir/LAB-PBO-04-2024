import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;

abstract class Dog extends Parent implements Move{
    
    public Dog(Object position, Walk walk) {
        this.position = position;
        this.walk = walk;
    }

    abstract void describe() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException;

    static void enterDog(Dog pitbull, Dog siberian, Dog bulldog, Dog shepherd) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        Dog dog;
        outerloop:
        while (true) {
            while (true) {
                System.out.printf("%s\n", "=".repeat(Map.getLebar()));
                System.out.println("Silahkan pilih jenis Dog:\n1. Pitbull\n2. Siberian Husky\n3. Bulldog\n4. German Shepherd\n5. Kembali");
                int menu = (int) Main.inputUserAngka("= ");
                if (menu == 1) {
                    dog = pitbull;
                    AudioFile.Audio("Audio\\Pitbull.wav");
                    break;
                }
                else if (menu == 2) {
                    dog = siberian;
                    AudioFile.Audio("Audio\\Husky.wav");
                    break;
                }
                else if (menu == 3) {
                    dog = bulldog;
                    AudioFile.Audio("Audio\\Bulldog.wav");
                    break;
                }
                else if (menu == 4) {
                    dog = shepherd;
                    AudioFile.Audio("Audio\\German.wav");
                    break;
                }
                else if (menu == 5) {
                    break outerloop;
                }
                else{
                    System.out.println("Invalid input");
                }
            }
            while (true) {
                System.out.printf("%s\n", "=".repeat(Map.getLebar()));
                System.out.println("Silahkan pilih opsi : \n1. Ubah posisi\n2. Tampilkan deskripsi\n3. Kembali");
                int menu = (int) Main.inputUserAngka("= ");
                if (menu == 1) {
                    dog.move();
                }
                else if (menu == 2) {
                    dog.describe();
                }
                else if (menu == 3) {
                    break;
                }
                else{
                    System.out.println("Invalid input");
                }
            }
        }
    }
}

class Pitbull extends Dog{
    public Pitbull(Object position, Walk walk) {
        super(position, walk);
    }

    @Override
    public void move() {
        System.out.printf("%s\n", "=".repeat(Map.getLebar()));
        System.out.println("Pitbull sedang jalan-jalan di rumah");
        System.out.printf("%s\n", "=".repeat(Map.getLebar()));
        Map.printMap(this);
    }

    @Override
    void describe() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        while (true) {
            System.out.printf("%s\n", "=".repeat(Map.getLebar()));
            System.out.println("Sifat: Setia, penuh kasih, dan berani.\nKecepatan: 25-30 km/jam.\nPosisi: X: " + this.getPosition().getX() + ", Y: " + this.getPosition().getY() +  "\nTotal jalan : " + this.getWalk().total + "\nNaik: " + this.getWalk().w + "\nKiri: " + this.getWalk().a + "\nKanan: " + this.getWalk().d + "\nBawah: " + this.getWalk().s +"\nKetik 'suara' untuk mendengar suara.\nKetik 'kembali' untuk kembali ke menu utama.");
            String respon = Main.inputUserKosong("= ").toLowerCase();
            if (respon.equals("suara")) {
                AudioFile.Audio("Audio\\Pitbull.wav");
            }
            else if (respon.equals("kembali")) {
                break;
            }
            else{
                System.out.printf("%s\n", "-".repeat(Map.getLebar()));
                System.out.println("Invalid input");
            }
        }
    }

}

class Siberian extends Dog{
    public Siberian(Object position, Walk walk) {
        super(position, walk);
    }

    @Override
    public void move() {
        System.out.printf("%s\n", "=".repeat(Map.getLebar()));
        System.out.println("Siberian Husky sedang sedang berburu");
        System.out.printf("%s\n", "=".repeat(Map.getLebar()));
        Map.printMap(this);
    }

    @Override
    void describe() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        while (true) {
            System.out.printf("%s\n", "=".repeat(Map.getLebar()));
            System.out.println("Sifat: Energetik, ramah, dan keras kepala.\nKecepatan: 20-25 km/jam.\nPosisi: X: " + this.getPosition().getX() + ", Y: " + this.getPosition().getY() +  "\nTotal jalan : "+ this.getWalk().total+"\nNaik: " + this.getWalk().w + "\nKiri: " + this.getWalk().a + "\nKanan: " + this.getWalk().d + "\nBawah: " + this.getWalk().s +"\nKetik 'suara' untuk mendengar suara.\nKetik 'kembali' untuk kembali ke menu utama.");
            String respon = Main.inputUserKosong("= ").toLowerCase();
            if (respon.equals("suara")) {
                AudioFile.Audio("Audio\\Husky.wav");
            }
            else if (respon.equals("kembali")) {
                break;
            }
            else{
                System.out.printf("%s\n", "-".repeat(Map.getLebar()));
                System.out.println("Invalid input");
            }
        }
    }

}
class Bulldog extends Dog{
    public Bulldog(Object position, Walk walk) {
        super(position, walk);
    }

    @Override
    public void move() {
        System.out.printf("%s\n", "=".repeat(Map.getLebar()));
        System.out.println("Bulldog sedang menjaga halaman rumah");
        System.out.printf("%s\n", "=".repeat(Map.getLebar()));
        Map.printMap(this);
    }

    @Override
    void describe() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        while (true) {
            System.out.printf("%s\n", "=".repeat(Map.getLebar()));
            System.out.println("Sifat: Santai, ramah, dan setia.\nKecepatan: 15 km/jam.\nPosisi: X: " + this.getPosition().getX() + ", Y: " + this.getPosition().getY() +  "\nTotal jalan : "+ this.getWalk().total+"\nNaik: " + this.getWalk().w + "\nKiri: " + this.getWalk().a + "\nKanan: " + this.getWalk().d + "\nBawah: " + this.getWalk().s +"\nKetik 'suara' untuk mendengar suara.\nKetik 'kembali' untuk kembali ke menu utama.");
            String respon = Main.inputUserKosong("= ").toLowerCase();
            if (respon.equals("suara")) {
                AudioFile.Audio("Audio\\Bulldog.wav");
            }
            else if (respon.equals("kembali")) {
                break;
            }
            else{
                System.out.printf("%s\n", "-".repeat(Map.getLebar()));
                System.out.println("Invalid input");
            }
        }
    }

}

class Shepherd extends Dog{
    public Shepherd(Object position, Walk walk) {
        super(position, walk);
    }

    @Override
    public void move() {
        System.out.printf("%s\n", "=".repeat(Map.getLebar()));
        System.out.println("Shepherd German sedang mencari jejak");
        System.out.printf("%s\n", "=".repeat(Map.getLebar()));
        Map.printMap(this);
    }

    @Override
    void describe() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        while (true) {
            System.out.printf("%s\n", "=".repeat(Map.getLebar()));
            System.out.println("Sifat: Protektif, cerdas, dan setia\nKecepatan: 30-40 km/jam.\nPosisi: X: " + this.getPosition().getX() + ", Y: " + this.getPosition().getY() +  "\nTotal jalan : "+ this.getWalk().total+"\nNaik: " + this.getWalk().w + "\nKiri: " + this.getWalk().a + "\nKanan: " + this.getWalk().d + "\nBawah: " + this.getWalk().s +"\nKetik 'suara' untuk mendengar suara.\nKetik 'kembali' untuk kembali ke menu utama.");
            String respon = Main.inputUserKosong("= ").toLowerCase();
            if (respon.equals("suara")) {
                AudioFile.Audio("Audio\\German.wav");
            }
            else if (respon.equals("kembali")) {
                break;
            }
            else{
                System.out.printf("%s\n", "-".repeat(Map.getLebar()));
                System.out.println("Invalid input");
            }
        }
    }
}