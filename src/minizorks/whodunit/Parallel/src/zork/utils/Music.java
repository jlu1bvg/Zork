package minizorks.whodunit.Parallel.src.zork.utils;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private static Clip audioClip;

    public Music() {
        try {
            File audioFile = new File("src\\minizorks\\whodunit\\Parallel\\src\\zork\\data\\music 1.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error while initializing audio player: " + e);
        }
    }

    public void play() {
        if (audioClip != null) {
            audioClip.start();
        }
    }

    public static void stop() {
        if (audioClip != null) {
            audioClip.stop(); 
            audioClip.close();
        }
    }

    // public static void main(String[] args) {
    //     Music player = new Music("src/zork/data/yourSoundFile.wav");
    //     player.play();

    //     try {
    //         Thread.sleep(100000000); 
    //     } catch (InterruptedException e) {
    //         System.out.println("Interrupted Exception: " + e);
    //     }

    //     player.stop();
    // }
}
