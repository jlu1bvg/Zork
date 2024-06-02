package zork;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Zork {

    private static final String ASCII_ART_FILE_PATH = "src\\zork\\data\\KDstudios.txt";

    private static final String RESET = "\033[0m";
    private static final String[] COLORS = {
            "\033[31m", 
            "\033[32m",
            "\033[33m", 
            "\033[34m",
            "\033[35m", 
            "\033[36m",
            "\033[37m"  
    };

    public static void main(String[] args) {
        try {
            String asciiArt = new String(Files.readAllBytes(Paths.get(ASCII_ART_FILE_PATH)));
            printAsciiArtWithAnimation(asciiArt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Game game = new Game();
        // game.play();
        // MapHorseRacing.runMapHorseRace(); //npc moving not working so basically unusable
        // OtherHorseRacing.runOtherHorseRace(); //not compatible with anything but works
        // MultiHorseRacing.runMultiHorseRace();
        // Bootstrapper.runMultiHorseRacing();
        // Bootstrapper.runPrimequest();
        // Bootstrapper.runPrimequest();
        // Bootstrapper.runUndertale();
        // Bootstrapper.runWhodunit();
        // Bootstrapper.runPrimequest();
        Bootstrapper.runZork();
    }

    private static void printAsciiArtWithAnimation(String asciiArt) {
        String[] lines = asciiArt.split("\n");

        for (String line : lines) {
            for (char c : line.toCharArray()) {
                int colorIndex = (int) (Math.random() * COLORS.length);
                System.out.print(COLORS[colorIndex] + c + RESET);
                try {
                    Thread.sleep(getDelay(c));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
    private static int getDelay(char c) {
        switch (c) {
            case '|':
            case '_':
                return 1;
            default:
                return 1;
        }
    }
}
