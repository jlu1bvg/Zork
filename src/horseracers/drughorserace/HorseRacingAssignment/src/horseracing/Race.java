package horseracers.drughorserace.HorseRacingAssignment.src.horseracing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Race { // Class for each specific Race, with horses length and surface
    private List<Horse> horses;
    private double raceLength; // in furlongs
    private String raceSurface; // "grass", "dirt", or "mud" (Uses HorseRacingHelper constants)
    private int currentHorse;

   


    private List<Horse> results;


    public Race(List<Horse> horses, double raceLength, String raceSurface) {
        this.horses = horses;
        this.raceLength = raceLength;
        this.raceSurface = raceSurface;
        this.currentHorse = 0;
        this.results = new ArrayList<Horse>();
    }

    public List<Horse> getHorses() { // getter for the current horses
        return horses;
    }

    public void payOut(){ // logic for pay out, depending on bet type
        if(Player.getBettingMode().equalsIgnoreCase("win")){
            if(results.get(0).getName().equalsIgnoreCase(Player.getWinBetHorse())){
                System.out.print("Your bet won " + Player.getBet()*3 +"! "); 
                Player.setWallet(Player.getWallet()+Player.getBet()*3); 
                System.out.println("Your new balance is " + Player.getWallet());
            }
            else {
                System.out.println("------------------");
                System.out.println("You had a losing bet. Your remaining Balance is " + Player.getWallet()); 
                System.out.println("------------------"); }
        }

        if(Player.getBettingMode().equalsIgnoreCase("place")){
            if(results.get(0).getName().equalsIgnoreCase(Player.getPlaceBetHorse())|| results.get(1).getName().equalsIgnoreCase(Player.getPlaceBetHorse())){
                System.out.print("Your bet won " + Player.getBet()*2.5 +"! "); 
                Player.setWallet(Player.getWallet()+Player.getBet()*2.5); 
                System.out.println("Your new balance is " + Player.getWallet());
            }
            else {
                System.out.println("------------------");
                System.out.println("You had a losing bet. Your remaining Balance is " + Player.getWallet());
                System.out.println("------------------"); }
        }

        if(Player.getBettingMode().equalsIgnoreCase("show")){
            if(results.get(0).getName().equalsIgnoreCase(Player.getShowBetHorse())|| results.get(1).getName().equalsIgnoreCase(Player.getShowBetHorse())){
                System.out.print("Your bet won " + Player.getBet()*2 +"! "); 
                Player.setWallet(Player.getWallet()+Player.getBet()*2); 
                System.out.println("Your new balance is " + Player.getWallet());
        }
            else {
                System.out.println("------------------");
                System.out.println("You had a losing bet. Your remaining Balance is " + Player.getWallet());
                System.out.println("------------------"); }
        }
    }

    public int numHorses(){ // getter for the amount of horses
        return horses.size();
    }

    public Horse getNextHorse(){ // returns the next horse
        if (currentHorse == horses.size())
            currentHorse = 0;
        
        return horses.get(currentHorse++);
    }

    public double getRaceLength() { // getter for race length
        return raceLength;
    }

    public Horse getCurrentHorse(){ // getter for current horse
        return horses.get(currentHorse);
    }

    public String getRaceSurface() { // getter for race surface
        return raceSurface;
    }
    

    public void displayRaceInfo() { // displays the GUI for the race information
        System.out.println("-----Race Information:-----");
        System.out.println("+---------------+---------------+");
        String a1 = "Race Surface";
        String k1 = "Race Length";
        System.out.printf("|%15s|%15s|\n", a1, k1 );
        String k3 = raceSurface;
        String k4 = "" + raceLength;
        System.out.println("+---------------+---------------+");
        System.out.printf("|%-15s|%15s|\n", k3, k4 );
        System.out.println("+---------------+---------------+");
        displayHorseTable();
    }

    public void displayHorseTable(){ // displays the table with the horses names and all their stats and betting odds

        System.out.println(" ");
        System.out.println("+-----+-------------------------+---------------+---------------+---------------+---------------+----------+----------+----------+");
        String a1 = "#";
        String k1 = "Horse Name";
        String k2 = "Prefered Length";
        String k3 = "Grass Rating"; 
        String k4 = "Mud Rating";
        String k5 = "Dirt Rating";
        String k6 = "Win Odds";
        String k7 = "Place Odds";
        String k8 = "Show Odds";

        System.out.printf("|%-5s|%-25s|%15s|%15s|%15s|%15s|%10s|%10s|%10s|\n", a1, k1, k2, k3, k4, k5, k6, k7, k8);

        for (int i = 0; i < horses.size(); i++) {
            Horse horse = horses.get(i);
            String n1 = "" + (i + 1);
            String s1 = "" + horse.getName();
            String s2 = "" + horse.getPreferredLength();
            String s3 = "" + horse.getGrassRating();
            String s4 = "" + horse.getMudRating();
            String s5 = "" + horse.getDirtRating();
            String s6 = "" + this.getOdds(i, "win");
            String s7 = "" + this.getOdds(i, "place");
            String s8 = "" + this.getOdds(i, "show");
 
            System.out.println("+-----+-------------------------+---------------+---------------+---------------+---------------+----------+----------+----------+");
            System.out.printf("|%-5s|%-25s|%15s|%15s|%15s|%15s|%10s|%10s|%10s|\n", n1, s1, s2, s3, s4, s5, s6, s7, s8);
        }
        System.out.println("+-----+-------------------------+---------------+---------------+---------------+---------------+----------+----------+----------+");
    }


    public double lengthOddsMultiplyer (int x){ // Logic for preferred length stat on horses

        Horse horseOdds = horses.get(x);
        double lengthMultiplyer = (int)(7 - Math.abs(horseOdds.getPreferredLength() - this.raceLength));
        return lengthMultiplyer;

    }

    public double surfaceOddsMultiplyer (int x){ // Logic for preferred surface stat on horses

        Horse horseOdds = horses.get(x);
        double surfaceMultiplyer = 0;
        boolean multiComplete = true;

        while (multiComplete!=false){
        if (raceSurface.equals("grass"))
            surfaceMultiplyer += horseOdds.getGrassRating() / 2;
            multiComplete = false;
        if (raceSurface.equals("dirt"))
            surfaceMultiplyer += horseOdds.getDirtRating() / 2;
            multiComplete = false;
        if (raceSurface.equals("mud"))
            surfaceMultiplyer += horseOdds.getMudRating() / 2;
            multiComplete = false;
        }
        return surfaceMultiplyer;
    }



    public String getOdds(int current, String betType){ // Calculates the odds for the table, condensed from three methods into one

        Horse Horse = horses.get(current);
        double preferredLength = Horse.getPreferredLength();
        int multiplier;

        if ("Dirt".equals(raceSurface)) {
            multiplier = 10-Horse.getDirtRating();
        } else if ("Grass".equals(raceSurface)) {
            multiplier = 10-Horse.getGrassRating();
        } else if ("Mud".equals(raceSurface)) {
            multiplier = 10-Horse.getMudRating();
        } else {
            multiplier = 1;
        }

        double lengthMultiplier = Math.abs(preferredLength - raceLength) + 1;
        String odds = "";

        if(betType.equals("win")) {
            if((multiplier + lengthMultiplier)%3 == 0)
            odds += (int)(multiplier + lengthMultiplier)/3 + "-1";
        
            else
            odds += (int)(multiplier + lengthMultiplier) + "-3";
        } else if(betType.equals("place")) {
            if((multiplier + lengthMultiplier)%3 == 0)
            odds += (int)((multiplier + lengthMultiplier)/3)+2 + "-1";
        
            else
            odds += (int)(multiplier + lengthMultiplier)+2 + "-3";
        } else if(betType.equals("show")) {
            if((multiplier + lengthMultiplier)%3 == 0)
            odds += (int)((multiplier + lengthMultiplier)/3)+3 + "-1";

            else
            odds += (int)(multiplier + lengthMultiplier)+3 + "-3";
        }
        
        return odds;
    }

    public void displayResults(){ // Displays results
        System.out.println("\n\nRace Results");
        System.out.println("------------");
        for(int i=0; i<results.size(); i++){
            System.out.println((i+1) + ": " + results.get(i).getName() + "("+results.get(i).getNumber()+")");
        }
    }

   

    public void startRace(){ // Starts the race, plays music, and checks if horses have finished the race
        resetHorses();
        int numSpaces = (int)(raceLength*10);
        boolean done = false;
        HorseRacingHelper.pauseForMilliseconds(1000);
        HorseRacingHelper.playBackgroundMusicAndWait("src"+File.separator+"horseracers"+File.separator+"drughorserace"+File.separator+"HorseRacingAssignment"+File.separator+"Race.wav");
        HorseRacingHelper.playBackgroundMusic("src"+File.separator+"horseracers"+File.separator+"drughorserace"+File.separator+"HorseRacingAssignment"+File.separator+"horse_gallop.wav", true);

        while(!done){
            HorseRacingHelper.pauseForMilliseconds(100);
            HorseRacingHelper.clearConsole();
            HorseRacingHelper.updateTrack(numSpaces, horses);
            Horse horse = getNextHorse();
           

            if(!horse.raceFinished() && horse.getCurrentPosition() >= numSpaces){
                results.add(horse);
                horse.setRaceFinished(true);
            } else if(!horse.raceFinished()){
                horse.incrementPosition(getIncrement(horse)); 
            }

            displayResults();

            if (results.size() == horses.size())
                done = true;
        }

        HorseRacingHelper.stopMusic();
    }


    private int getIncrement(Horse horse) { // Gets how far the horse will move each turn, affected by rating and mob effects
        int increment =0;
        increment+=(int)(7-Math.abs(horse.getPreferredLength()-this.raceLength));
        if(raceSurface.equals("Grass"))
            increment+=horse.getGrassRating();
        if(raceSurface.equals("Mud"))
            increment+=horse.getMudRating();
        if(raceSurface.equals("Dirt"))
            increment+=horse.getDirtRating();
        
        int x = 7;

        if((horse.isDrugged())){
            x = 10;
        } if (!horse.isExempt() && Player.getSabataged()) {
            x = 5;
        }
        System.out.println("increment" + increment);
        return ((int)(Math.random() * increment) + x);
    }


    private void resetHorses() { // Resets horses
        for (Horse horse : horses) {
            horse.resetCurrenPosition();
        }
    }

    public void removeMobEffects(List<Horse> horses) { // Ensures horses affected by mob effects revert back to normal
        Player.setSabataged(false);
        for (Horse horse : horses) {
            if(horse.isDrugged()) {
                horse.setDrugged(false);
            }            
        }

    }
}
