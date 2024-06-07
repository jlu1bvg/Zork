package zork;

import java.util.*;

public class Puzzles {
    public static boolean manualPuzzleChest() {
        Scanner in = new Scanner(System.in);
        
        String guess = in.nextLine();
        
        if (guess.equals("work no play dull boy")) {
            System.out.println("As you input the last letter, you hear a click coming from the chest.");
            return true;
        }

        return false;
    }

    public static boolean manualPuzzlePaper() {
        // Jack starts typing
        // have the player type in the code letter by letter
        // give them the manual puzzle paper as a reward

        String manualKey = "work no play dull boy";
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

    public static boolean batteryPuzzle() {
        Boolean isCharged = false;
        int juice = (int)(Math.random() * 26) + 20; // generate random num 20-45 (battery percentage)
        Scanner in = new Scanner(System.in);

        System.out.println("You pick up a battery off the floor. Turning it over, you spot a small green illuminated rectangle which reads: Battery life - " + juice + "%");

        // MISSING - user chooses to charge the battery
        System.out.println("Enter the percentage of life to add to the battery: ");
        String add = in.nextLine();

        int addedLife = 0;
        try {
            addedLife = Integer.parseInt(add);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        juice += addedLife;
        if (juice > 100)
            juice = 100;

        System.out.println("Updated battery life: " + juice + "%");

        Timer timer = new Timer();       
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            //    juice -= 3;
            }
        }, 0, 120000);

        // show this if the user inputs "show battery life or something"
        if (isCharged && juice >= 80)
            System.out.println("The battery is now fully charged!");
        
        if (juice < 80)
            System.out.println("The battery will not work in the Snowcat.");

        return false;
    }
}
