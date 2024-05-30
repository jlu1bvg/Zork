package horseracers.drughorserace.HorseRacingAssignment.src.horseracing;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class Player{
        private String name;
        private static double currentBet;
        private static double wallet;
        public static String bettingMode;
        public static String winBetHorse = ""; 
        public static String showBetHorse;
        public static String placeBetHorse;
        public static boolean mobUnlocked;
        public static double tipAmount;
        public static boolean isSabataged;
        private static int round;
    



        public Player(double startingBalance) { // Class for the player, all attributes that need to persist beyond games are in here.
            this.name = askName();
            this.wallet = startingBalance;
            this.currentBet = 0;
            this.bettingMode = "";
            this.mobUnlocked = false;
            this.isSabataged = false;
        }

        public static double getTipAmount() { // getter for tip amount
            return tipAmount;
        }


        public static void setTipAmount(double tipAmount) { // setter for tip amount
            Player.tipAmount = tipAmount;
        }

        public boolean getMobUnlocked(){ // getter for mob unlocked
            return mobUnlocked;
        }


        public static void setMobUnlocked(boolean isMobUnlocked){ // setter for mob unlocked
            mobUnlocked = isMobUnlocked; 
        }

        public static boolean getSabataged() { // getter for sabataged
            return isSabataged;
        }

        public static void setSabataged(boolean isSabataged) { // setter for sabataged
            Player.isSabataged = isSabataged;
        }

        
        
       public String askName() { // Promts user for name
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        return in.nextLine();
       }

       public String getName(){ // getter for player name
            return name;
       }

       public static String getWinBetHorse(){ // getter for win bet horse
            return winBetHorse;
       }

       public static String getShowBetHorse(){ // getter for show bet horse
            return showBetHorse;
        }

        public static String getPlaceBetHorse(){ // getter for place bet horse
            return placeBetHorse;
       }

       public static String getBettingMode(){ // getter for betting mode
        return bettingMode;
        }

       public static void setWallet(double amount) { // setter for wallet
        wallet = amount;
       }

       public static double getWallet() { // getter for wallet
        return wallet;
       }

       public static double getBet() { // could potentially make the betting odds so that the bank doesnt lose any money
        return currentBet;
       }

       public void setBet(double amount) { // setter for current bet
        currentBet = amount;
       }

       public static int getRound() { // returns round
        return round;
        }

        public static void nextRound() { // increments round counter (for mob)
            round++;
        }


    public void checkHorses(List<Horse> horses) { // Method to make sure the horse the player picks is actually in the race 
        Scanner in=new Scanner(System.in);
        boolean goodHorse = false;
        while(!goodHorse){
            System.out.println("Which horse would you like to bet on to win first, second, or third? Ensure it is a horse racing in this race.");
            showBetHorse=in.nextLine();
            for (Horse horse : horses) {
                if (showBetHorse.equalsIgnoreCase(horse.getName()))
                    goodHorse=true;
            }
        }
    }

    private static void askSteroid(List<Horse> horses) {// Method to ask which horse the player wants to steroid, called in askMob
        String steroidHorse = "";
        boolean goodHorse = false;
        while(!goodHorse){
            Scanner in = new Scanner(System.in);
            System.out.println("Select a horse to steroid: (Ensure it is a horse racing in this race.) OR Exit: ");
            steroidHorse = in.nextLine();
            if (steroidHorse.equalsIgnoreCase("exit")) {
                goodHorse = true;
                break;
            }
            for (Horse horse : horses) {
                if (steroidHorse.equalsIgnoreCase(horse.getName())) {
                    goodHorse = true;
                    horse.setDrugged(true);
                }
            } if (!goodHorse) {
                System.out.println("That horse is not in the race");
            }
        }     
    }



    
    private static void askSabotage(List<Horse> horses) { // Method to ask which horse the player wants to sabotage, called in askMob
        String excludedHorse = "";
        boolean goodHorse = false;
        while(!goodHorse){
            Scanner in = new Scanner(System.in);
            System.out.println("Select a horse to exclude from the sabotage: (Ensure it is a horse racing in this race.) OR Exit: ");
            excludedHorse = in.nextLine();
            if (excludedHorse.equalsIgnoreCase("exit")) {
                goodHorse = true;
                break;
            }
            for (Horse horse : horses) {
                if (excludedHorse.equalsIgnoreCase(horse.getName())) {
                    goodHorse = true;
                    horse.setExempt(true);
                }
            }
            if (!goodHorse) {
                System.out.println("That horse is not in the race");
            }
        } 
    }

    public void displayPlayerInfo(){ // displays player info
        for (int i = 0; i < 5; i++){
            String s1 = "name: " + name;
            String s2 = "ballance: " + wallet;
            String s3 = "bet amount: " + currentBet; // make multiple betts and make the table dependent 
            //String s4 = "horse: " + horse;

            System.out.println("+-----+-----+-----+-----+");
            System.out.printf("|%5s|%5s|%5s|%5s|\n", s1,s2,s3);
            }
            System.out.printf("+-----+-----+-----+-----+");
        }

        public void askMob(List<Horse> horses){ // Method to ask the player whether they want to use the mobs Sabotage or Steroids. Only Called when Mob is unlocked
            Scanner in = new Scanner(System.in);
            boolean mobAsked = false;
            boolean choicePicked = false;
            while(!mobAsked){
                System.out.println("");
                System.out.print("Do you want to call the mob? - yes / no: ");
                String mobYN = in.nextLine();
                if(mobYN.equalsIgnoreCase("yes")){
                    System.out.println("So...");
                    HorseRacingHelper.pauseForMilliseconds(1000);
                    System.out.println("whats your pill of choice?");
                    HorseRacingHelper.pauseForMilliseconds(1000);
                    System.out.println("Sabotage?");
                    HorseRacingHelper.pauseForMilliseconds(1000);
                    System.out.println("...or steroid?");
                    HorseRacingHelper.pauseForMilliseconds(1000);
                    System.out.println("Wallet: " + Player.getWallet());
                    while (!choicePicked) {
                        System.out.println(choicePicked);
                        System.out.print("Please Enter Sabotage $130, Steroid $90, or Exit: ");
                        String choice = in.nextLine();
                        if(choice.equalsIgnoreCase("Sabotage")) {
                            if(Player.getWallet() >= 130) {
                                askSabotage(horses);
                                mobAsked = true;
                                choicePicked = true;
                                Player.setWallet(Player.getWallet() - 130);
                            } else {
                                System.out.println("You aint got enough money for that");
                            }
                            setSabataged(true);
                        } else if (choice.equalsIgnoreCase("Steroid")) {
                            if(Player.getWallet() >= 90) {
                                askSteroid(horses);
                                mobAsked = true;
                                choicePicked = true;
                                Player.setWallet(Player.getWallet() - 90);
                            } else {
                                System.out.println("You aint got enough money for that");
                            }
                        } else if (choice.equalsIgnoreCase("Exit")) {
                            mobAsked = true;
                            choicePicked = true;
                            System.out.println("Ok then, your loss, see you tomorrow");
                        } else {
                            System.out.println("Invalid Response");
                        }
                    }
                }else if (mobYN.equalsIgnoreCase("no")){
                    mobAsked= true;
                } else {
                    System.out.println("Invalid Response");
                }
            }
        }

        public void askBet(List<Horse> horses) { // Asks the player how much they want to bet, What type of bet, and which horse they want to bet on
            Scanner in = new Scanner(System.in);
            boolean validBet=false;
            double amount = 0;
            while(!validBet) {
                System.out.println("Wallet: " + getWallet());
                int min = 2; 
                double max=wallet;
    
                boolean isValid = false;
                int result = 0;
        
                while(!isValid){
                    System.out.print("Please enter a bet amount: ");
                    
                    try{
                        amount = Integer.parseInt(in.nextLine());
                        result = (int)amount;
                        if (result < min || result > max)
                            System.out.println("Ensure your bet is within our wallet limit and more than the minimum bet, $2.");
                        else{
                            isValid = true;
                            validBet = true;
                        }
                    }catch(NumberFormatException badThing){
                        System.out.println("Whole Numbers only!");
                    }
        
                }

            }
    
            System.out.println("What kind of bet would you like to make? (win, place, or show)");
            bettingMode = in.nextLine(); 
            
            while(!(bettingMode.equalsIgnoreCase("win")|| bettingMode.equalsIgnoreCase("place")|| bettingMode.equalsIgnoreCase("show"))){
                System.out.println("Please enter a valid bet type (win, place, or show)");
                bettingMode = in.nextLine();
            }

            checkHorses(horses);
            setBet(amount);
            setWallet((getWallet() - amount));
        }
       
    }
       
       
    

