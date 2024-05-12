package Sound;
import javax.sound.sampled.*;

public class AudioSound {

    public static void playSound(String soundPath) {
        try {
            // Buat AudioInputStream untuk file suara
            AudioInputStream sound = AudioSystem.getAudioInputStream(AudioSound.class.getResourceAsStream(soundPath));

            // Dapatkan format audio dari suara
            AudioFormat format = sound.getFormat();

            // Buat DataLine.Info untuk Clip, yang digunakan untuk memainkan suara
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // Dapatkan Line dari DataLine.Info untuk suara
            Clip clip = (Clip) AudioSystem.getLine(info);

            // Baca suara ke dalam Clip
            clip.open(sound);
            clip.start(); // Mainkan suara
            clip.drain(); // Tunggu sampai suara selesai diputar

            // Tutup AudioInputStream
            sound.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}