package horseracers.maphorserace.HorseRacingAssignment.src.horseracing;

import java.util.Scanner;

public class MapHorseRacing {
    private static boolean gameOver=false;

    public static void runMapHorseRace() {
        Scanner in = new Scanner(System.in);    
        HorseRacingHelper.prepareHorseRacingSimulation();
        gameOver = false;
        Player player = new Player();


        while(!gameOver){
            HorseRacingHelper.clearConsole();

            Street street = new Street();
            Buildings bank = new Buildings("bank");
            Buildings store = new Buildings("shop");
            Venue venue = new Venue("Horse Racing Venue");
            NPC npc = new NPC();

            store.drawStore(npc, player);
            bank.drawBank(npc, player);
            Street.drawStreet(bank, store, venue, npc);

            Street.renderStreet(in, bank, store, npc, venue , player);

            System.out.println("Game is Over");

            gameOver = playAgain(in);
        }
    }

    private static boolean playAgain(Scanner in) {
        System.out.print("\u001B[?25l");  // Hide the cursor

        System.out.print("Play Again: (y/n): ");
        String result = in.nextLine();

        if (result.equals("n")){
            HorseRacingHelper.clearConsole();
            return true;
        }

        return false;

    }

    public static void setGameOver(boolean status){
        gameOver=status;
    }
}
