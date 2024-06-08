package zork;

import java.util.*;

public class Puzzles {
    public static boolean manualPuzzleChest() {
        Scanner in = new Scanner(System.in);
        System.out.println("touching the chest you input your guess");

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
        //String manualKey = "work no play dull boy";
        String manualKey = "a";
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

    public static boolean wires() {
        Scanner in = new Scanner(System.in);
        double numScrews = 4;
        int correct = 0;

        System.out.println(numScrews + " screws face you as you attempt to open the telephone");
        if (!Player.getInventory().containsItem(Game.getAllItems().get("screwdriver"))) {
            System.out.println("however it seems you don't have the necessary tools to remove them");
        }

        while (numScrews*2 > 0 && Player.getInventory().containsItem(Game.getAllItems().get("screwdriver"))) {
            String RESET = "\u001B[0m";
            String RED = "\u001B[31m";
            String GREEN = "\u001B[32m";
            String YELLOW = "\u001B[33m";
            String BLUE = "\u001B[34m";

            int random = (int) (Math.random()*4 + 1);
            if (random == 1) {
                System.out.println(BLUE + "+    " + RESET + ">   *   #");
            }
            if (random == 2) {
                System.out.println("+   " + RED + ">   " + RESET+ "*   #");
            }
            if (random == 3) {
                System.out.println("+   >   " + GREEN + "*   " + RESET+ "#");
            }
            if (random == 4) {
                System.out.println("+   >   *   " + YELLOW + "#" + RESET);
            }

            String response = in.nextLine();
            if (random == 1 && response.equals("+")) {
                correct++;
                numScrews-= 0.5;
            }
            if (random == 2 && response.equals(">")) {
                correct++;
                numScrews-= 0.5;
            }
            if (random == 3 && response.equals("*")) {
                correct++;
                numScrews-= 0.5;
            }
            if (random == 4 && response.equals("#")) {
                correct++;
                numScrews-= 0.5;
            }
            System.out.println(correct);
        }
        
        if (correct == 8) {
            return true;
        }

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

    public static boolean engine() {
        Scanner in = new Scanner(System.in);
        int count = 0;

        System.out.println("you feel as if there may be some use to switching the switches");

        for (int i=0; i<10; i++) {
            int random = (int) (Math.random()*10 + 1);
            String answer;

            if (random <= 5) {
                System.out.println("|>|");
            }
            if (random > 5) {
                System.out.println("|<|");
            }

            answer = in.nextLine();

            if (random <= 5 && answer.equals("<")) {
                count++;
            }
            if (random > 5 && answer.equals(">")) {
                count++;
            }
        }

        if (count == 10) {
            return true;
        }

        return false;
    }

    public static boolean fuelCan() {
        Scanner in = new Scanner(System.in);
        String answer;
    
        System.out.println("as you think of how you could get the item behind the ice block a picture appears in your mind but you cant remember the name of the object");

        System.out.println("⠀⢱⣆⠀⠀⠀⠀⠀⠀\n" + //
        "⠀⠀⠀⠀⠀⠀⠈⣿⣷⡀⠀⠀⠀⠀\n" + //
        "⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣧⠀⠀⠀\n" + //
        "⠀⠀⠀⠀⡀⢠⣿⡟⣿⣿⣿⡇⠀⠀\n" + //
        "⠀⠀⠀⠀⣳⣼⣿⡏⢸⣿⣿⣿⢀⠀\n" + //
        "⠀⠀⠀⣰⣿⣿⡿⠁⢸⣿⣿⡟⣼⡆\n" + //
        "⢰⢀⣾⣿⣿⠟⠀⠀⣾⢿⣿⣿⣿⣿\n" + //
        "⢸⣿⣿⣿⡏⠀⠀⠀⠃⠸⣿⣿⣿⡿\n" + //
        "⢳⣿⣿⣿⠀⠀⠀⠀⠀⠀⢹⣿⡿⡁\n" + //
        "⠀⠹⣿⣿⡄⠀⠀⠀⠀⠀⢠⣿⡞⠁\n" + //
        "⠀⠀⠈⠛⢿⣄⠀⠀⠀⣠⠞⠋⠀⠀\n" + //
        "⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀");

        answer = in.nextLine();

        if (answer.equalsIgnoreCase("fire")) {
            return true;
        }

        return false;
    }
}
