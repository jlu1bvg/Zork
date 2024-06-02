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
        initFolders("src"+File.separator+"zork"+File.separator+"data"+File.separator+"folders.json");
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
                computerCommand=parser.getComputerCommand(currentFolder.getFolderPath());
                runningDDOS=processComputerCommand(computerCommand);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        HorseRacingHelper.clearConsole();
    }

    private void bootup() throws InterruptedException{
        int timeScale=bootTime*100/100;
        for(int i=0;i<=50;i++){
            int delay=(int)(Math.random()*100000);
            if(delay>100&&delay<2000){
                Thread.sleep(timeScale+delay);
            }
            else{
                Thread.sleep(timeScale);
            }
            HorseRacingHelper.clearConsole();
            System.out.println("  _____    _____     ____     _____ \r\n" + //
                             " |  __ \\  |  __ \\   / __ \\   / ____|\r\n" + //
                             " | |  | | | |  | | | |  | | | (___  \r\n" + //
                             " | |  | | | |  | | | |  | |  \\___ \\ \r\n" + //
                             " | |__| | | |__| | | |__| |  ____) |\r\n" + //
                             " |_____/  |_____/   \\____/  |_____/ ");
            System.out.println("  ___            _  __  ___    ___   _  _ \r\n" + //
                                " | _ )  _  _    | |/ / |   \\  | __| | \\| |\r\n" + //
                                " | _ \\ | || |   |   <  | |) | | _|  |    |\r\n" + //
                                " |___/  \\_  |   |_|\\_\\ |___/  |___| |_|\\_|\r\n" + //
                                "        |__/ ");
            System.out.print("|");
            for(int j=0;j<i;j++){
                System.out.print("-");
            }
            for(int k=50-i;k>0;k--){
                System.out.print(" ");
            }
            System.out.print("|");
        }
        HorseRacingHelper.playBackgroundMusic("src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Windows Final Vista.wav", false);
        clearConsole(null);
    }

    private static boolean processComputerCommand(ComputerCommand computerCommand) {
        if (computerCommand.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return true;
        }

        Consumer<ComputerCommand> action = computerCommandActions.get(computerCommand.getComputerCommandWord().toLowerCase());
        if (action != null) {
            action.accept(computerCommand);
            return !(computerCommand.getComputerCommandWord().equals("exit") && !computerCommand.hasSecondWord());
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
        computerCommandActions.put("dir",computerCommand->currentFolder.printChangeDirectories());
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
        folder.setFolderPath(folderPath);

        JSONArray jsonChangeDirectories = (JSONArray) ((JSONObject) folderObj).get("changeDirectories");
        ArrayList<ChangeDirectory> changeDirectories = new ArrayList<>();
        for (Object changeDirectoryObj : jsonChangeDirectories) {
            String directoryName = (String) ((JSONObject) changeDirectoryObj).get("directory");
            String directoryPath = (String) ((JSONObject) changeDirectoryObj).get("directoryPath");
            ChangeDirectory changeDirectory = new ChangeDirectory(directoryName, directoryPath);
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
        } 
        else {
            runningDDOS=false;
        }
      }
}
