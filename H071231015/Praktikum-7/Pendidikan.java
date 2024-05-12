import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Pendidikan extends Kehidupan{
    private static String edu;
    public static String getEdu() {return edu;}

    static String SD() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        return Main.inputUserKosong("Masukkan nama SD : ");
    }
    static String SMP() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        return Main.inputUserKosong("Masukkan nama SMP : ");
    }
    static String SMA() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        return Main.inputUserKosong("Masukkan nama SMA : ");
    }
    static String SMK() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        return Main.inputUserKosong("Masukkan nama SMK : ");
    }
    static String S1() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        String jurusan = Main.inputUserKosong("Masukkan sarjana : ");
        String univ = Main.inputUserKosong("Masukkan nama Universitas : ");
        return jurusan + " " + univ;
    }
    static String S2() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        String jurusan = Main.inputUserKosong("Masukkan magister : ");
        String univ = Main.inputUserKosong("Masukkan nama Universitas : ");
        return jurusan + " " + univ;
    }
    static String S3() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        String jurusan = Main.inputUserKosong("Masukkan doktor : ");
        String univ = Main.inputUserKosong("Masukkan nama Universitas : ");
        return jurusan + " " + univ;
    }
    
    @Override
    void prosesKehidupan() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            System.out.printf("%s\n", "=".repeat(50));
            edu = Main.inputUserKosong("Pendidikan terakhir (SD/SMP/SMA/SMK/S1/S2/S3): ").toUpperCase();
            if (edu.equals("SD")) {
                edu = "SD " + Pendidikan.SD();
                break;
            }
            else if (edu.equals("SMP")) {
                edu = "SMP " + Pendidikan.SMP();
                break;
            }
            else if (edu.equals("SMA")) {
                edu = "SMA " + Pendidikan.SMA();
                break;
            }
            else if (edu.equals("SMK")) {
                edu = "SMK " + Pendidikan.SMK();
                break;
            }
            else if (edu.equals("S1")) {
                edu = "S1 " + Pendidikan.S1();
                break;
            }
            else if (edu.equals("S2")) {
                edu = "S2 " + Pendidikan.S2();
                break;
            }
            else if (edu.equals("S3")) {
                edu = "S3 " + Pendidikan.S3();
                break;
            }
            else{
                System.out.printf("%s\n", "-".repeat(50));
                System.out.println("Invalid Input");
                AudioFile.Audio("wrong_input.wav");
            }
        }
    }
}