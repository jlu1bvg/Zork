package minizorks.undertale.TextAdventure.src.zork;

/**
 * Exit
 */
public class Exit extends OpenableObject {
  private String direction;
  private String adjacentRoom;

  public Exit(String direction, String adjacentRoom, boolean isLocked, String keyId) {
    super(isLocked);
    this.direction = direction;
    this.adjacentRoom = adjacentRoom;
  }

  public Exit(String direction, String adjacentRoom, boolean isLocked) {
    super(isLocked);
    this.direction = direction;
    this.adjacentRoom = adjacentRoom;
  }

  public Exit(String direction, String adjacentRoom) {
    this.direction = direction;
    this.adjacentRoom = adjacentRoom;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getAdjacentRoom() {
    return adjacentRoom;
  }

  public void setAdjacentRoom(String adjacentRoom) {
    this.adjacentRoom = adjacentRoom;
  }

}