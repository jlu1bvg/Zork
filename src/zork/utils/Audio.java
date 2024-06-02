package zork.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    private String name;
    private boolean isPlaying;
    private double volume;
    private Clip clip;

    public Audio(String name, String filePath) {
        this.name = name;
        this.isPlaying = false;
        this.volume = 0.5; 

        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void play() {
        if (!isPlaying) {
            isPlaying = true;
            clip.start();
        }
    }

    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            clip.stop();
        }
    }

    public void stop() {
        if (isPlaying) {
            isPlaying = false;
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        if (volume >= 0.0 && volume <= 1.0) {
            this.volume = volume;
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }

    public void mute() {
        setVolume(0.0);
    }

    public void unmute(double previousVolume) {
        setVolume(previousVolume);
    }
}
