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
import zork.Bootstrapper;
import zork.Game;
import zork.Parser;

public class DDOS {
    private static boolean runningDDOS;
    private static int bootTime=1;
    private static Map<String,Consumer<ComputerCommand>> computerCommandActions=new HashMap<>();
    private Folder currentFolder;
    private Parser parser;
    public static boolean playing=false;

    public DDOS(Parser parser) {
        this.parser=parser;
        try {
        initFolders("src"+File.separator+"zork"+File.separator+"data"+File.separator+"folders.json");
        currentFolder = Game.folderMap.get("C:\\Users\\StuartUllman");
        initFiles("src"+File.separator+"zork"+File.separator+"data"+File.separator+"files.json");
        // initExecutables();
        } catch (Exception e) {
        e.printStackTrace();
        }
        initializeCommands();
    }

    public void runDDOS() throws InterruptedException{
        runningDDOS=true;
        bootup();
        while(runningDDOS&&!playing){
            ComputerCommand computerCommand;
            try {
                computerCommand=parser.getComputerCommand(currentFolder);
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
            int delay=(int)(Math.random()*100000);
            if(delay>100&&delay<2000){
                Thread.sleep(timeScale+delay);
            }
            else{
                Thread.sleep(timeScale);
            }
            HorseRacingHelper.clearConsole();
        }
        HorseRacingHelper.playBackgroundMusic("src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"DDOS"+File.separator+"Windows Final Vista.wav", false);
        clearConsole(null);
    }

    private static boolean processComputerCommand(ComputerCommand computerCommand) {
        if (computerCommand.isUnknown()) {
            System.out.println("Invalid command");
            return true;
        }

        Consumer<ComputerCommand> action = computerCommandActions.get(computerCommand.getComputerCommandWord().toLowerCase());
        if (action != null) {
            action.accept(computerCommand);
            return !(computerCommand.getComputerCommandWord().equals("exit") && !computerCommand.hasSecondWord());
        } 
        else {
            System.out.println("Invalid command");
            return true;
        }
    }

    private void initializeCommands() {
        computerCommandActions.put("help", computerCommand -> Parser.showComputerCommands());
        computerCommandActions.put("clear", this::clearConsole);
        computerCommandActions.put("exit", this::processQuit);
        computerCommandActions.put("dir",computerCommand->currentFolder.printChangeDirectories());
        computerCommandActions.put("cd", this::changeDirectory);
        computerCommandActions.put("open", this::runExecutable);
    }

    private void initFiles(String jsonName) throws Exception {
        Path path = Path.of(jsonName);
        String jsonString = Files.readString(path);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);

        JSONArray jsonFiles = (JSONArray) json.get("files");

        for (Object fileObj : jsonFiles) {
            String fileName = (String) ((JSONObject) fileObj).get("name");
            String filePath = (String) ((JSONObject) fileObj).get("path");
            String fileType=(String)((JSONObject)fileObj).get("type");
            zork.DDOS.File file=new zork.DDOS.File(fileName,fileType);
            
            Game.folderMap.get(filePath.substring(0,filePath.indexOf(fileName)-1)).addFile(file);
        }
        initExecutables();
    }

    private void initExecutables(){
        Game.folderMap.get("C:\\Users\\StuartUllman\\Games").executables.put("PrimeQuest.exe", file->Bootstrapper.runPrimequest());
        Game.folderMap.get("C:\\Users\\StuartUllman\\Games").executables.put("Whodunit.exe", file->Bootstrapper.runWhodunit());
        Game.folderMap.get("C:\\Users\\StuartUllman\\Games").executables.put("Undertale.exe", file->Bootstrapper.runUndertale());
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

    private void runExecutable(ComputerCommand command){
        currentFolder.runExecutable(currentFolder.getFile(command.getSecondWord()));
        HorseRacingHelper.clearConsole();
    }

    private void changeDirectory(ComputerCommand command){
        if(command.getSecondWord()==null){
            System.out.println("No given folder");
        }
        else if(command.getSecondWord().equals("..")){
            if(currentFolder.getFolderPath().equals("C:")){
                System.out.println("Cannot go back");
            }
            else{
                Folder newFolder=Game.folderMap.get(currentFolder.getFolderPath().substring(0,currentFolder.getFolderPath().indexOf(currentFolder.getFolderName())-1));
                if(newFolder==null){
                    System.out.println("Folder not found");
                }
                else{
                    currentFolder=newFolder;
                }
            }
        }
        else{
            Folder newFolder=Game.folderMap.get(currentFolder.getFolderPath()+"\\"+command.getSecondWord());
            if(newFolder==null){
                System.out.println("Folder not found");
            }
            else{
                currentFolder=newFolder;
            }
        }
    }

    private void clearConsole(ComputerCommand command){
        HorseRacingHelper.clearConsole();

        System.out.println("Deslauriers Disk Operating System for Enterprise v9.11");
        System.out.println("Copyright Kevin Deslauriers Enterprise Networks. All rights reserved.");
        System.out.println("");
        System.out.println("help - Shows all commands");
    }

    public static void clearConsole(){
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
