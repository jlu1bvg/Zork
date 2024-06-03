package zork.DDOS;

/**
 * Exit
 */
public class ChangeDirectory{
  private String directory;
  private String adjacentFolder;

  public ChangeDirectory(String directory, String adjacentFolder) {
    this.directory = directory;
    this.adjacentFolder = adjacentFolder;
  }

  public String getDirectory() {
    return directory;
  }

  public void setDirectory(String directory) {
    this.directory = directory;
  }

  public String getAdjacentFolder() {
    return adjacentFolder;
  }

  public void setAdjacentFolder(String adjacentFolder) {
    this.adjacentFolder = adjacentFolder;
  }

}