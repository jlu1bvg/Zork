package horseracers.drughorserace.HorseRacingAssignment.src.horseracing;

import java.util.List;
import java.util.Scanner;

public class DrugHorseRacing {
     public static void runDrugHorseRace() { // Main command that runs everything

        int raceLength = (int)(Math.random()*2)+1;

        Scanner in = new Scanner(System.in);    
        HorseRacingHelper.prepareHorseRacingSimulation();
        Player player = new Player(500.00); // Creates Player Object
        Player.nextRound();
        boolean gameOver = false;
        while(!gameOver){ 
            HorseRacingHelper.clearConsole();

            int numHorsesInRace = (int)(Math.random()*7)+5;

            int raceType = (int)(Math.random()*3);
            Race race = HorseRacingHelper.createRace(numHorsesInRace, raceLength, raceType);
            

            race.displayRaceInfo();
            player.askBet(race.getHorses());
            if (player.getMobUnlocked()){ // Checks to see if mob unlocked before prompting the mob menu
                player.askMob(race.getHorses());
            }

            race.startRace();

            System.out.println("Race is Over");
            race.payOut();
            race.removeMobEffects(race.getHorses());

            gameOver = playAgain(in);
        }

        
    }

    private static boolean playAgain(Scanner in) { // Prompts the user to play again, Also prompts user with the mob call after 4 races + $100 of bet money
        System.out.print("\u001B[?25l");  // Hide the cursor
        boolean hasChosenTip = false;
        while(!hasChosenTip) {
        System.out.println("Would you like to tip the bookie?");
        String bookieYn = in.nextLine();
        if(bookieYn.equalsIgnoreCase("yes")){
            try {
                System.out.println("How much would you like to tip: ");
                int tip = in.nextInt();
                if(tip <= Player.getWallet()) {
                Player.setWallet(Player.getWallet() - tip);
                Player.setTipAmount(Player.getTipAmount() + tip);
                hasChosenTip = true;  
                } else {
                    System.out.println("Invalid funds");
                }              
            } catch(NumberFormatException badThing){
                System.out.println("Numbers only!");
            }
        } else if (bookieYn.equalsIgnoreCase("no")) {
            System.out.println("You cheapscate");
            hasChosenTip = true;
        } else {
            System.out.println("Please respons Yes or No");
        }
        } 
        HorseRacingHelper.pauseForMilliseconds(2000);
        System.out.println("Round Number" + Player.getRound() + "  -  Tip Amount " + Player.getTipAmount());
        HorseRacingHelper.pauseForMilliseconds(2000);
        

        if((Player.getRound() == 4)&&(Player.getTipAmount()>=100)){

            System.out.println("Brookie: I have found a opportunity for you...");
            HorseRacingHelper.pauseForMilliseconds(1000);
            System.out.println("Brookie: There is a mob that comes here often...");
            HorseRacingHelper.pauseForMilliseconds(1000);
            System.out.println("Brookie: Try calling them, there might be somthing in it for you...");
            HorseRacingHelper.pauseForMilliseconds(1000);
            System.out.println("Here's there number, 647 937 9837");
            HorseRacingHelper.pauseForMilliseconds(1000);
            System.out.println("Call the Mob? - yes / no");
            boolean hasChosenMob = false;
            while(!hasChosenMob) {
            String res = in.nextLine();
            if (res.equalsIgnoreCase("yes")){
                Player.setMobUnlocked(true);
                System.out.println("Mob: Hey, we heard your a regular at the track.");
                HorseRacingHelper.pauseForMilliseconds(1000);
                System.out.println("You pay us money, and we will sabotage any horse for you");
                HorseRacingHelper.pauseForMilliseconds(1000);
                System.out.println(".. or you can chose to steriod a horse of your pick.");
                HorseRacingHelper.pauseForMilliseconds(1000);
                System.out.println("Its a risky business, if somthing goes south, we never met");
                HorseRacingHelper.pauseForMilliseconds(1000);
                System.out.println("Alright, we'll discuss this tomorrow, right before the race");
                hasChosenMob = true;
            } else if (res.equalsIgnoreCase("no")) {
                System.out.println("Aright then, its your loss.");
                hasChosenMob = true;
            } else {
                System.out.println("I need a yes or no");
            }
            }
        }
        System.out.print("Play Again: (y/n): ");
        String result = in.nextLine();
        if (result.equals("n")) {
            HorseRacingHelper.clearConsole();
            return true;
        } else {
            Player.nextRound();
            return false;
        }
    }
}
