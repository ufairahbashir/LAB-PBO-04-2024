import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main{

    static double inputUserAngka(String tanya){
        Scanner input = new Scanner(System.in);
        double check;
        while (true) {
            System.out.print(tanya);
            String cek = input.nextLine().trim();
            if (cek.isEmpty()) {
                System.out.printf("%s\n", "-".repeat(Map.getLebar()));
                System.out.println("Inputan tidak boleh kosong");
            }
            else{
                try {
                    check = Integer.parseInt(cek);
                    if (check <= 0) {
                        System.out.printf("%s\n", "-".repeat(Map.getLebar()));
                        System.out.println("Input tidak boleh nagatif ataupun bernilai 0");
                    }
                    else{
                        break;
                    }
                } catch (Exception e) {
                    System.out.printf("%s\n", "-".repeat(Map.getLebar()));
                    System.out.println("Terjadi error karena " + e);
                }
            }
        }
        return check;
    }

    static String inputUserKosong(String tanya){
        Scanner input = new Scanner(System.in);
        String ans;
        while (true) {
            System.out.print(tanya);
            ans = input.next();
            if (ans.trim().isEmpty()) {
                System.out.printf("%s\n", "-".repeat(Map.getLebar()));
                System.out.println("Inputan tidak boleh kosong");
            }
            else{
                break;
            }
        }
        return ans;
    }

    int menu;

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        Pitbull pitbull = new Pitbull(new Object(2, 0), new Walk(0, 0, 0, 0, 0));
        Siberian siberian = new Siberian(new Object(2, 0) , new Walk(0, 0, 0, 0, 0));
        Bulldog bulldog = new Bulldog(new Object(2, 0) , new Walk(0, 0, 0, 0, 0));
        Shepherd shepherd = new Shepherd(new Object(2, 0) , new Walk(0, 0, 0, 0, 0));

        Samsung samsung = new Samsung(24000000, "Samsung S24 Ultra");
        Iphone iphone = new Iphone(20000000, "Iphone 15 pro max");
        Toy toy = new Toy(10000, "Hp mainan");
        Anime anime = new Anime(3000000, "Anime phone");

        Audi audi = new Audi(new Object(2, 0) , new Walk(0, 0, 0, 0, 0),6, "Merah", 250);
        Porsche porsche = new Porsche(new Object(2, 0) , new Walk(0, 0, 0, 0, 0), 7, "Hitam", 300);
        Lamborghini lamborghini = new Lamborghini(new Object(2, 0) , new Walk(0, 0, 0, 0, 0), 6, "Kuning", 350);
        Mercedes mercedes = new Mercedes(new Object(2, 0) , new Walk(0, 0, 0, 0, 0), 5, "Silver", 280);


        while (true) {
            System.out.printf("%s\n", "=".repeat(Map.getLebar()));
            System.out.println("Silahkan pilih kategori :\n1. Dog\n2. Smartphone\n3. Car\n4. Diagram\n5. Keluar");
            int menu = (int) inputUserAngka("= ");
            if (menu == 1) {
                Dog.enterDog(pitbull, siberian, bulldog, shepherd);
            }
            else if (menu == 2) {
                Phone.enterPhone(samsung, iphone, toy, anime);
            }
            else if (menu == 3) {
                CarAbility.enterCar(audi, porsche, lamborghini, mercedes);
            }
            else if (menu == 4) {
                Diagram.TampilkanMenu();
            }
            else if (menu == 5) {
                System.exit(1);
            }
            else{
                System.out.println("Invalid input");
            }
            
        }
    }
}