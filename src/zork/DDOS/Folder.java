package zork.DDOS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.HorseRacingHelper;
import zork.Game;

public class Folder {

  private String folderName;
  private String folderPath;
  private ArrayList<ChangeDirectory> changeDirectories;
  private ArrayList<File> files=new ArrayList<File>();
  public Map<String,Consumer<File>> executables=new HashMap<>();

  public ArrayList<ChangeDirectory> getChangeDirectories() {
    return changeDirectories;
  }

  public void printChangeDirectories(){
    System.out.printf("%-20s %-50s\n","Type","Name");
    System.out.println();
    if(changeDirectories.size()==1&&files==null&&!folderPath.equals("C:")){
      for(ChangeDirectory changeDirectory:changeDirectories){
        System.out.printf("%-20s %-50s\n","Folder",changeDirectory.getDirectory());
      }
      System.out.println("-----Folder empty-----");
    }
    else{
      for(ChangeDirectory changeDirectory:changeDirectories){
        System.out.printf("%-20s %-50s\n","Folder",changeDirectory.getDirectory());
      }
      if(files!=null){
        for(File file:files){
          System.out.printf("%-20s %-50s\n",file.getType(),file.getName());
        }
      }
    }
  }

  public void setChangeDirectories(ArrayList<ChangeDirectory> changeDirectories) {
    this.changeDirectories = changeDirectories;
  }

  public void runExecutable(File file){
    Consumer<File> run = executables.get(file.getName());
    if (run != null) {
      DDOS.playing=true;
      HorseRacingHelper.clearConsole();
      int timeScale=100/100;
      for(int i=0;i<=20;i++){
          System.out.println("Loading "+file.getName());
          System.out.print("|");
          for(int j=0;j<i;j++){
              System.out.print("-");
          }
          for(int k=20-i;k>0;k--){
              System.out.print(" ");
          }
          System.out.print("|");
          int delay=(int)(Math.random()*100000);
          if(delay>100&&delay<2000){
              try {
                Thread.sleep(timeScale+delay);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
          }
          else{
              try {
                Thread.sleep(timeScale);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
          }
          HorseRacingHelper.clearConsole(); 
      }
      run.accept(file);      
    } 
    else {
      System.out.println("Invalid thing");
    }
  }

  /**
   * Create a room described "description". Initially, it has no directories.
   * "description" is something like "a kitchen" or "an open court yard".
   */
  // public Folder(String description) {
  //   this.description = description;
  //   directories = new ArrayList<ChangeDirectory>();
  // }

  public Folder() {
    folderName = "DEFAULT ROOM";
    changeDirectories = new ArrayList<ChangeDirectory>();
  }

  public void addChangeDirectory(ChangeDirectory changeDirectory) throws Exception {
    changeDirectories.add(changeDirectory);
  }

  /**
   * Return a string describing the room's directories, for example "Directorys: north west
   * ".
   */
  public String changeDirectoryString() {
    String returnString = "ChangeDirectories: ";
    for (ChangeDirectory changeDirectory : changeDirectories) {
      returnString += changeDirectory.getDirectory() + " ";
    }

    return returnString;
  }

  /**
   * Return the room that is reached if we go from this room in direction
   * "direction". If there is no room in that direction, return null.
   */
  public Folder nextFolder(String directory) {
    try {
      for (ChangeDirectory changeDirectory : changeDirectories) {

        if (changeDirectory.getDirectory().equalsIgnoreCase(directory)) {
          String adjacentFolder = changeDirectory.getAdjacentFolder();

          return Game.folderMap.get(adjacentFolder);
        }

      }
    } catch (IllegalArgumentException ex) {
      System.out.println(directory + " is not a valid direction.");
      return null;
    }

    System.out.println(directory + " is not a valid direction.");
    return null;
  }

  /*
   * private int getDirectionIndex(String direction) { int dirIndex = 0; for
   * (String dir : directions) { if (dir.equals(direction)) return dirIndex; else
   * dirIndex++; }
   * 
   * throw new IllegalArgumentException("Invalid Direction"); }
   */
  public String getFolderName() {
    return folderName;
  }

  public void setFolderName(String folderName) {
    this.folderName = folderName;
  }

  public void setFolderPath(String folderPath){
    this.folderPath=folderPath;
  }

  public String getFolderPath(){
    return folderPath;
  }

  public ArrayList<File> getFiles() {
    return files;
  }

  public File getFile(String fileName){
    for(File file:files){
      if(file.getName().equals(fileName)){
        return file;
      }
    }
    return new File(null, null);
  }

  public Boolean checkFile(String name){
    if(files!=null){
      for(File file:files){
        if(file.getName().equalsIgnoreCase(name)){
          return true;
        }
      }
    }
    return false;
  }

  public void addFile(File i) {
    files.add(i);
  }
  
  public void removeFile(File i) {
    files.remove(i);
  }
}
