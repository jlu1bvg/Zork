package zork.DDOS;

import java.util.ArrayList;

import zork.Game;

public class Folder {

  private String folderName;
  private String folderPath;
  private ArrayList<ChangeDirectory> changeDirectories;
  private ArrayList<File> files;

  public ArrayList<ChangeDirectory> getChangeDirectories() {
    return changeDirectories;
  }

  public void printChangeDirectories(){
    System.out.printf("%-20s %-50s\n","Type","Name");
    System.out.println();
    for(ChangeDirectory changeDirectory:changeDirectories){
      System.out.printf("%-20s %-50s\n","Folder",changeDirectory.getDirectory());
    }
    if(files!=null){
      for(File file:files){
        System.out.printf("%-20s %-50s\n",file.getType(),file.getName());
      }
    }
  }

  public void setChangeDirectories(ArrayList<ChangeDirectory> changeDirectories) {
    this.changeDirectories = changeDirectories;
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

  public Folder addFile(File i) {
    files.add(i);
    return this;
  }
  
  public Folder remove(File i) {
    files.remove(i);
    return this;
  }
}
