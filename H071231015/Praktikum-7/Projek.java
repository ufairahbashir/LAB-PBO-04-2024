import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Projek extends Kehidupan{
    private static int project;
    public static int getProject() {return project;}
    
    void prosesKehidupan() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            System.out.printf("%s\n", "=".repeat(50));
            project = (int) Main.inputUserAngka("Projek IT:\n1. Minimal 4\n2. Minimal 8\n3. Minimal 12\n4. Lebih dari 15\nInput: ");
            if (project == 1 || project == 2 || project == 3 || project == 4) {
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
