package horseracers.otherhorserace.src.horseracing;

import java.util.Scanner;

public class OtherHorseRacing {

     public static void runOtherHorseRace() {
        Scanner in = new Scanner(System.in);    
        HorseRacingHelper.prepareHorseRacingSimulation();
        boolean gameOver = false;
        while(!gameOver){
            HorseRacingHelper.clearConsole();    

            int numHorsesInRace = (int)(Math.random()*7)+5;

            Race race = HorseRacingHelper.createRace(numHorsesInRace, HorseRacingHelper.SHORT, HorseRacingHelper.DIRT);
            race.displayRaceInfo(); 

            race.Betting();

            race.startRace();

            race.displayamountwon(); 

            System.out.println("Race is Over");
            // gameOver = playAgain(in);
            gameOver=true;
        }
        
    }

    // private static boolean playAgain(Scanner in) {
    //     System.out.print("\u001B[?25l");  // Hide the cursor

    //     System.out.print("Play Again: (y/n): ");
    //     String result = in.nextLine();

    //     if (result.equals("n"))
    //         return true;

    //     return false;

    // }

}
