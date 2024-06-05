import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

    static double inputUserAngka(String tanya) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        Scanner input = new Scanner(System.in);
        double check;
        while (true) {
            System.out.print(tanya);
            String cek = input.nextLine().trim();
            if (cek.isEmpty()) {
                System.out.printf("%s\n", "-".repeat(50));
                System.out.println("Inputan tidak boleh kosong");
                AudioFile.Audio("wrong_input.wav");
            }
            else{
                try {
                    check = Integer.parseInt(cek);
                    if (check <= 0) {
                        System.out.printf("%s\n", "-".repeat(50));
                        System.out.println("Input tidak boleh nagatif ataupun bernilai 0");
                        AudioFile.Audio("wrong_input.wav");
                    }
                    else{
                        break;
                    }
                } catch (Exception e) {
                    System.out.printf("%s\n", "-".repeat(50));
                    System.out.println("Inputan harus berupa integer");
                    AudioFile.Audio("wrong_input.wav");
                }
            }
        }
        return check;
    }
    
    static String inputUserKosong(String tanya) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        Scanner input = new Scanner(System.in);
        String ans;
        while (true) {
            System.out.print(tanya);
            ans = input.next();
            if (ans.trim().isEmpty()) {
                System.out.printf("%s\n", "-".repeat(50));
                System.out.println("Inputan tidak boleh kosong");
                AudioFile.Audio("wrong_input.wav");
            }
            else{
                break;
            }
        }
        return ans;
    }

    


    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        ArrayList<Karyawan> daftarKaryawan= new ArrayList<>();
        ArrayList<Pelamar> daftarPelamar= new ArrayList<>();
        ArrayList<String> daftarNomorInduk = new ArrayList<>();

        while (true) {
            System.out.printf("%s\n", "=".repeat(50));
            System.out.println("Data Karyawan:\na. Tambah data karyawan\nb. Tampilkan detail karyawan\nc. Tampilkan diagram\nd. Keluar");
            String input = inputUserKosong("Pilih opsi (a-d): ").toLowerCase();
            switch (input) {
                case "a":
                Menu.tambah(daftarPelamar, daftarKaryawan, daftarNomorInduk);
                    break;
                case "b":
                Menu.tampil(daftarPelamar, daftarKaryawan);
                    break;
                case "c":
                Diagram.TampilkanMenu();
                    break;
                case "d":
                System.exit(0);
                    break;
                default:
                    System.out.printf("%s\n", "-".repeat(50));
                    System.out.println("Invalid Input");
                    AudioFile.Audio("wrong_input.wav");
                    break;
            }
        }
    }
}
