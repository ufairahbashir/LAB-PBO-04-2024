import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Keluarga extends Kehidupan{
    private static String berkeluarga;
    public static String getBerkeluarga() {return berkeluarga;}

    void prosesKehidupan() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            String tanya = Main.inputUserKosong("Apakah sudah berkeluarga? (ya/tidak) : ").toLowerCase();
            if (tanya.equals("ya")) {
                berkeluarga = "Pelamar sudah berkeluarga, disarankan memberikan gaji diatas UMR";
                break;
            }
            else if (tanya.equals("tidak")) {
                berkeluarga = "Pelamar belum berkeluarga, mohon berikan gaji yang tepat";
                break;
            }
            else{
                System.out.printf("%s\n", "-".repeat(50));
                System.out.println("Inputan tidak boleh kosong");
                AudioFile.Audio("wrong_input.wav");
            }
        }        
    }
}
