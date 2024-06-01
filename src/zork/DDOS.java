package zork;

import java.io.IOException;
import java.util.Scanner;

import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.HorseRacingHelper;

public class DDOS {
    private ComputerCommandWords commands;
    private Scanner in;
    private static boolean runningDDOS;
    private static int bootTime=1;

    public static void runDDOS(Parser parser) throws InterruptedException{
        runningDDOS=true;
        bootup();
        while(runningDDOS){
            ComputerCommand computerCommand;
            try {
                computerCommand=parser.getComputerCommand();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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
            System.out.print("Deslauriers Disk Operating System Pro for Enterprise v9.11\n"+
                                "  _____  _____   ____   _____ \r\n" + //
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
        HorseRacingHelper.playBackgroundMusic("src\\zork\\data\\audio\\Windows Final Vista.wav", false);
        HorseRacingHelper.clearConsole();

        System.out.println("Deslauriers Disk Operating System for Enterprise v9.11");
        System.out.println("Copyright Kevin Deslauriers Enterprise Networks. All rights reserved.");
        System.out.println("");
        System.out.println("help - Shows all commands");
    }


}
