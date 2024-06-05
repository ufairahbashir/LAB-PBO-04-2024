import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Pengalaman extends Kehidupan {
    private static String organisasi;
    
    private static double salary = 0;
    private static int exp;
    
    public static int getExp() {return exp;}
    public static double getSalary() {return salary;}
    public static String getOrganisasi() {return organisasi;}

    static void organisasi() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        String namaOrganisasi = Main.inputUserKosong("Masukkan nama organisasi : ");
        String jabatan = Main.inputUserKosong("Masukkan jabatan dalam organisasi : ");
        organisasi = jabatan + " dalam organisasi " + namaOrganisasi;
    }

    @Override
    void prosesKehidupan() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        while (true) {
            System.out.printf("%s\n", "=".repeat(50));
            exp = (int) Main.inputUserAngka("Pengalaman sebelumnya:\n1. Freelancer\n2. Magang\n3. Pekerja tetap\n4. Organisasi\n5. Tidak ada\nInput: ");
            if (exp == 1 || exp == 2 || exp == 3) {
                salary = Main.inputUserAngka("Gaji sebelumnya: ");
                break;
            } 
            else if (exp == 4) {
                organisasi();
                break;
            } 
            else if (exp == 5) {
                break;
            } 
            else {
                System.out.printf("%s\\n", "-".repeat(50));
                System.out.println("Invalid Input");
                AudioFile.Audio("wrong_input.wav");
            }
        }
    }
}