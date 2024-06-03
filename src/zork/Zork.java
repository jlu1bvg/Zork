package zork;

import java.nio.file.Files;
import java.nio.file.Paths;
import zork.utils.Audio;
import zork.utils.Ascii;    
import zork.DDOS.DDOS;

public class Zork {
    private static final String ASCII_ART_FILE_PATH = "src\\zork\\data\\KDstudios.txt";
    public static void main(String[] args) {
        // try {
        //     String asciiArt = new String(Files.readAllBytes(Paths.get(ASCII_ART_FILE_PATH)));
        //     Ascii.printAsciiArtWithAnimation(asciiArt);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        Audio audio = new Audio("audio", "src\\zork\\data\\audio\\01 - Main Title The Shining.wav");
        //audio.play();
        Bootstrapper.runZork();
    }
}
