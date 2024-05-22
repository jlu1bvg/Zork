package minizorks.undertale.TextAdventure.src.zork;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayMusic {

    public static Clip clip;

    public static synchronized void play(String location, boolean newSong) {
        if (!Game.game.switchingAreas() && !newSong)
            return;
        stop();
        try {
            clip = AudioSystem.getClip();
            File musicPath = new File(location);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("File not found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }


}

