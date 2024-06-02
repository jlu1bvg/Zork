package zork.DDOS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.HorseRacingHelper;
import zork.Game;
import zork.Parser;

public class DDOS {
    private static boolean runningDDOS;
    private static int bootTime=1;
    private static Map<String,Consumer<ComputerCommand>> computerCommandActions=new HashMap<>();
    private Folder currentFolder;
    private static Parser Parser;

    public DDOS() {
        try {
        initFolders("src" + File.separator + "zork" + File.separator + "data" + File.separator + "rooms.json");
        currentFolder = Game.folderMap.get("C:\\Users\\StuartUllman");
        } catch (Exception e) {
        e.printStackTrace();
        }
        initializeCommands();
    }

    public void runDDOS(Parser parser) throws InterruptedException{
        Parser=parser;
        runningDDOS=true;
        bootup();
        while(runningDDOS){
            ComputerCommand computerCommand;
            try {
                computerCommand=parser.getComputerCommand();
                runningDDOS=processComputerCommand(computerCommand);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void bootup() throws InterruptedException{
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
        clearConsole(null);
    }

    private static boolean processComputerCommand(ComputerCommand computerCommand) {
        if (computerCommand.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        Consumer<ComputerCommand> action = computerCommandActions.get(computerCommand.getComputerCommandWord().toLowerCase());
        if (action != null) {
            action.accept(computerCommand);
            // return computerCommand.getComputerCommandWord().equals("quit") && !computerCommand.hasSecondWord();
            return true;
        } 
        else {
            System.out.println("I don't know what you mean...");
            return true;
        }
    }

    private void initializeCommands() {
        computerCommandActions.put("help", computerCommand -> Parser.showComputerCommands());
        computerCommandActions.put("clear", this::clearConsole);
        computerCommandActions.put("exit", this::processQuit);
        computerCommandActions.put("dir",computerCommand->currentFolder.getChangeDirectories());
      }

    private void initFolders(String fileName) throws Exception {
        Path path = Path.of(fileName);
        String jsonString = Files.readString(path);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);

        JSONArray jsonFolders = (JSONArray) json.get("folders");

        for (Object folderObj : jsonFolders) {
        Folder folder = new Folder();
        String folderName = (String) ((JSONObject) folderObj).get("name");
        String folderPath = (String) ((JSONObject) folderObj).get("path");
        folder.setFolderName(folderName);

        JSONArray jsonChangeDirectories = (JSONArray) ((JSONObject) folderObj).get("changeDirectories");
        ArrayList<ChangeDirectory> changeDirectories = new ArrayList<>();
        for (Object directoryObj : jsonChangeDirectories) {
            String directory = (String) ((JSONObject) directoryObj).get("directory");
            String adjacentPath = (String) ((JSONObject) directoryObj).get("adjacentPath");
            ChangeDirectory changeDirectory = new ChangeDirectory(directory, adjacentPath);
            changeDirectories.add(changeDirectory);
        }
        folder.setChangeDirectories(changeDirectories);
        Game.folderMap.put(folderPath, folder);
        }
    }

    private void clearConsole(ComputerCommand command){
        HorseRacingHelper.clearConsole();

        System.out.println("Deslauriers Disk Operating System for Enterprise v9.11");
        System.out.println("Copyright Kevin Deslauriers Enterprise Networks. All rights reserved.");
        System.out.println("");
        System.out.println("help - Shows all commands");
    }

    private void processQuit(ComputerCommand command) {
        if (command.hasSecondWord()) {
          System.out.println("Quit what?");
        } else {
          runningDDOS=false;
        }
      }
}
