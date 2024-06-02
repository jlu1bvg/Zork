package zork.DDOS;

import java.util.ArrayList;

import zork.Game;

public class Folder {

  private String folderName;
  private String description;
  private ArrayList<Directory> directories;
  private ArrayList<File> files;

  public ArrayList<Directory> getDirectories() {
    return directories;
  }

  public void setDirectories(ArrayList<Directory> directories) {
    this.directories = directories;
  }

  /**
   * Create a room described "description". Initially, it has no directories.
   * "description" is something like "a kitchen" or "an open court yard".
   */
  public Folder(String description) {
    this.description = description;
    directories = new ArrayList<Directory>();
  }

  public Folder() {
    folderName = "DEFAULT ROOM";
    description = "DEFAULT DESCRIPTION";
    directories = new ArrayList<Directory>();
  }

  public void addDirectory(Directory directory) throws Exception {
    directories.add(directory);
  }

  /**
   * Return the description of the room (the one that was defined in the
   * constructor).
   */
  public String shortDescription() {
    return "Room: " + folderName + "\n\n" + description;
  }

  /**
   * Return a long description of this room, on the form: You are in the kitchen.
   * Directorys: north west
   */
  public String longDescription() {

    return "Room: " + folderName + "\n\n" + description + "\n" + directoryString();
  }

  /**
   * Return a string describing the room's directories, for example "Directorys: north west
   * ".
   */
  private String directoryString() {
    String returnString = "Directorys: ";
    for (Directory directory : directories) {
      returnString += directory.getDirection() + " ";
    }

    return returnString;
  }

  /**
   * Return the room that is reached if we go from this room in direction
   * "direction". If there is no room in that direction, return null.
   */
  public Folder nextFolder(String direction) {
    try {
      for (Directory directory : directories) {

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
  public String getRoomName() {
    return folderName;
  }

  public void setRoomName(String roomName) {
    this.folderName = roomName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
