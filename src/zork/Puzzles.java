package zork;

import java.util.*;

public class Puzzles {
    /* 5 puzzles total: battery, fuel can, wires, find missing tire, engine ?
    chest object - player must unscramble a phrase "All work and no play makes Jack a dull boy" which is found in a drawer in Jack's desk
    they must input it to open the chest, giving them 1/5 puzzles to fix the snowcat
    battery and fuel can - fuel can is located in the garage, player must find the battery first and somehow those two are related and "unlock" together
    fuel can is frozen in a block of ice, player must carry it inside and wait for it to melt
    wires are located next to telephone

    these puzzles are active during the "escape the hotel" and non-insane runthrough, where Jack is supposed to solve all puzzles and escape via snowcat
    */
    public static boolean manualPuzzleChest() {
        Scanner in = new Scanner(System.in);
        
        String guess = in.nextLine();
        
        if (guess.equals("all work and no play makes Jack a dull boy")) {
            System.out.println("As you input the last letter, you hear a click coming from the chest.");
            return true;
        }

        return false;
    }

    public static String manualPuzzlePaper() {
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
            return playersKey;
        }

        return null;
    }
}
