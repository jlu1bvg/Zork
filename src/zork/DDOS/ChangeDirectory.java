package zork.DDOS;

import zork.OpenableObject;

/**
 * Exit
 */
public class ChangeDirectory extends OpenableObject {
  private String directory;
  private String adjacentFolder;

  public ChangeDirectory(String directory, String adjacentFolder, boolean isLocked, String keyId) {
    super(isLocked, keyId);
    this.directory = directory;
    this.adjacentFolder = adjacentFolder;
  }

  public ChangeDirectory(String directory, String adjacentFolder, boolean isLocked, String keyId, Boolean isOpen) {
    super(isLocked, keyId, isOpen);
    this.directory = directory;
    this.adjacentFolder = adjacentFolder;
  }

  public ChangeDirectory(String directory, String adjacentFolder) {
    this.directory = directory;
    this.adjacentFolder = adjacentFolder;
  }

  public String getdirectory() {
    return directory;
  }

  public void setdirectory(String directory) {
    this.directory = directory;
  }

  public String getadjacentFolder() {
    return adjacentFolder;
  }

  public void setAdjacentFolder(String adjacentFolder) {
    this.adjacentFolder = adjacentFolder;
  }

}