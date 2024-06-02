package zork.DDOS;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.HorseRacingHelper;
import zork.Command;
import zork.Parser;

public class DDOS {
    private ComputerCommandWords commands;
    private Scanner in;
    private static boolean runningDDOS;
    private static int bootTime=1;
    private Map<String,Consumer<Command>> computerCommandActions=new HashMap<>();


    public DDOS() {
        try {
        initFolders("src" + File.separator + "zork" + File.separator + "data" + File.separator + "rooms.json");
        currentFolder = roomMap.get("Bedroom");
        } catch (Exception e) {
        e.printStackTrace();
        }
        initializeCommands();
    }

    public static void runDDOS(Parser parser) throws InterruptedException{
        runningDDOS=true;
        bootup();
        while(runningDDOS){
            ComputerCommand computerCommand;
            try {
                computerCommand=parser.getComputerCommand();
                runningDDOS=processCommand(computerCommand);
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
                                "  _____   _____    ____    _____ \r\n" + //
                                " |  __ \\ |  __ \\  / __ \\  / ____|\r\n" + //
                                " | |  | || |  | || |  | || (___  \r\n" + //
                                " | |  | || |  | || |  | | \\___ \\ \r\n" + //
                                " | |__| || |__| || |__| | ____) |\r\n" + //
                                " |_____/ |_____/  \\____/ |_____/\n\n\n\n\n\n\n\n|");
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

    private boolean processCommand(ComputerCommand computerCommand) {
        if (computerCommand.isUnknown()) {
        System.out.println("I don't know what you mean...");
        return false;
        }

        Consumer<ComputerCommand> action = computerCommandActions.get(computerCommand.getCommandWord().toLowerCase());
        if (action != null) {
        action.accept(computerCommand);
        return computerCommand.getCommandWord().equals("quit") && !computerCommand.hasSecondWord();
        } 
        else {
        System.out.println("I don't know what you mean...");
        return false;
        }
    }

    private void initializeCommands() {
        computerCommandActions.put("help", computerCommand -> printHelp());
        computerCommandActions.put("go", );
        computerCommandActions.put("quit", );
        computerCommandActions.put("eat", command -> System.out.println("Do you really think you should be eating at a time like this?"));
      }

}
