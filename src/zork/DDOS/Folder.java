package zork.DDOS;

import java.util.ArrayList;

import zork.Game;

public class Folder {

  private String folderName;
  private ArrayList<ChangeDirectory> directories;
  private ArrayList<File> files;

  public ArrayList<ChangeDirectory> getDirectories() {
    return directories;
  }

  public void setDirectories(ArrayList<ChangeDirectory> directories) {
    this.directories = directories;
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
    directories = new ArrayList<ChangeDirectory>();
  }

  public void addDirectory(ChangeDirectory directory) throws Exception {
    directories.add(directory);
  }

  /**
   * Return a string describing the room's directories, for example "Directorys: north west
   * ".
   */
  // private String directoryString() {
  //   String returnString = "Directorys: ";
  //   for (ChangeDirectory directory : directories) {
  //     returnString += directory.getDirection() + " ";
  //   }

  //   return returnString;
  // }

  /**
   * Return the room that is reached if we go from this room in direction
   * "direction". If there is no room in that direction, return null.
   */
  public Folder nextFolder(String folderName) {
    try {
      for (ChangeDirectory directory : directories) {

        if (directory.getDirection().equalsIgnoreCase(direction)) {
          String adjacentRoom = directory.getAdjacentRoom();

          return Game.folderMap.get(adjacentRoom);
        }

      }
    } catch (IllegalArgumentException ex) {
      System.out.println(direction + " is not a valid direction.");
      return null;
    }

    System.out.println(direction + " is not a valid direction.");
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
