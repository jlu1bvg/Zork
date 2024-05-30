package horseracers.drughorserace.HorseRacingAssignment.src.horseracing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class betlog{
    private int ID;
    private String name;
    private double currentBet;
    private String horse;
    private String bettype;
    private String round;
    

}



public void displayBettingLog(){ 
    System.out.println("+-----+-------------------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+");
    String a1 = "#";
    String k1 = "Name";
    String k2 = "Bet amount";
    String k3 = "horse"; 
    String k4 = "bet type";
    String k5 = "round";
    String k6 = "Delta";
    System.out.printf("|%-5s|%-25s|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", a1, k1, k2, k3, k4, k5, k6);

    for (int i = 0; i < .size(); i++) {
        Horse horse = horses.get(i);
        String n1 = "" + i;
        String s1 = "" + Player.Name();
        String s2 = "" + Player.getBet();
        String s3 = "" + Player.get();
        String s4 = "" + Player.getBettingMode();
        String s5 = "" + HorseRacing.round();
        String s6 = "" + this.getWinOdds(i)+":";
        String s7 = "" + this.getPlaceOdds(i);
        String s8 = "" + this.getShowOdds(i);

        System.out.println("+-----+-------------------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+");
        System.out.printf("|%-5s|%-25s|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", n1, s1, s2, s3, s4, s5, s6, s7, s8);
    }
    System.out.println("+-----+-------------------------+---------------+---------------+---------------+---------------+---------------+---------------+---------------+");
}

