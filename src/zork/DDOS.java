package zork;

import java.util.Scanner;

import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.HorseRacingHelper;

public class DDOS {
    private CommandWords commands;
    private Scanner in;
    private static boolean runningDDOS;
    private static int bootTime=1;

    public static void runDDOS() throws InterruptedException{
        runningDDOS=true;
        bootup();
    }

    private static void bootup() throws InterruptedException{
        int timeScale=bootTime*100/100;
        for(int i=0;i<=100;i++){
            int delay=(int)(Math.random()*100000);
            if(delay>100&&delay<2000){
                Thread.sleep(timeScale+delay);
            }
            else{
                Thread.sleep(timeScale);
            }
            HorseRacingHelper.clearConsole();
            System.out.print("Deslauriers Disk Operating System for Enterprise v9.11\n  _____  _____   ____   _____ \r\n" + //
                                " |  __ \\|  __ \\ / __ \\ / ____|\r\n" + //
                                " | |  | | |  | | |  | | (___  \r\n" + //
                                " | |  | | |  | | |  | |\\___ \\ \r\n" + //
                                " | |__| | |__| | |__| |____) |\r\n" + //
                                " |_____/|_____/ \\____/|_____/\n\n\n\n\n\n\n\n|");
            for(int j=0;j<i;j++){
                System.out.print("-");
            }
            for(int k=100-i;k>0;k--){
                System.out.print(" ");
            }
            System.out.print("|");
        }
        HorseRacingHelper.clearConsole();
    }


}
