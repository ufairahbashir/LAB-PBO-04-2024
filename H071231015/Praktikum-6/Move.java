import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

interface Move {
    void move() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException;
}
