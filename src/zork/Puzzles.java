package zork;

import java.util.*;

public class Puzzles {
    public static boolean manualPuzzleChest() {
        Scanner in = new Scanner(System.in);
        
        String guess = in.nextLine();
        
        if (guess.equals("all work and no play makes Jack a dull boy")) {
            System.out.println("As you input the last letter, you hear a click coming from the chest.");
            return true;
        }

        return false;
    }

    public static boolean manualPuzzlePaper() {
        // Jack starts typing
        // have the player type in the code letter by letter
        // give them the manual puzzle paper as a reward

        String manualKey = "all work and no play makes Jack a dull boy";
        String playersKey = "";
        Scanner in = new Scanner(System.in);

        System.out.println("As you sit, you feel a sudden urge come over you guiding you in what to type.");

        for (int i = 0; i < manualKey.length(); i++) {
            System.out.println("|" + manualKey.substring(i, i+1) + "|");
            playersKey += in.nextLine();
        }

        if (playersKey.equals(manualKey)) {
            return true;
        }

        return false;
    }

    public static boolean tirePuzzle() {


        return false;
    }
}
