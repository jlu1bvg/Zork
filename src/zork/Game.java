package zork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import zork.commands.go;

public class Game {

  public static HashMap<String, Room> roomMap = new HashMap<>();
  private Map<String, Consumer<Command>> commandActions = new HashMap<>();

  private Parser parser;
  private Room currentRoom;

  /**
   * Create the game and initialise its internal map
   */
  public Game() {
    try {
      initRooms("src" + File.separator + "zork" + File.separator + "data" + File.separator + "rooms.json");
      currentRoom = roomMap.get("Bedroom");
    } catch (Exception e) {
      e.printStackTrace();
    }
    parser = new Parser();
    initializeCommands();
  }

  private void initRooms(String fileName) throws Exception {
    Path path = Path.of(fileName);
    String jsonString = Files.readString(path);
    JSONParser parser = new JSONParser();
    JSONObject json = (JSONObject) parser.parse(jsonString);

    JSONArray jsonRooms = (JSONArray) json.get("rooms");

    for (Object roomObj : jsonRooms) {
      Room room = new Room();
      String roomName = (String) ((JSONObject) roomObj).get("name");
      String roomId = (String) ((JSONObject) roomObj).get("id");
      String roomDescription = (String) ((JSONObject) roomObj).get("description");
      room.setDescription(roomDescription);
      room.setRoomName(roomName);

      JSONArray jsonExits = (JSONArray) ((JSONObject) roomObj).get("exits");
      ArrayList<Exit> exits = new ArrayList<>();
      for (Object exitObj : jsonExits) {
        String direction = (String) ((JSONObject) exitObj).get("direction");
        String adjacentRoom = (String) ((JSONObject) exitObj).get("adjacentRoom");
        String keyId = (String) ((JSONObject) exitObj).get("keyId");
        Boolean isLocked = (Boolean) ((JSONObject) exitObj).get("isLocked");
        Boolean isOpen = (Boolean) ((JSONObject) exitObj).get("isOpen");
        Exit exit = new Exit(direction, adjacentRoom, isLocked, keyId, isOpen);
        exits.add(exit);
      }
      room.setExits(exits);
      roomMap.put(roomId, room);
    }
  }

  public void play() {
    printWelcome();

    boolean finished = false;
    while (!finished) {
      Command command;
      try {
        command = parser.getCommand();
        finished = processCommand(command);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Thank you for playing.  Good bye.");
  }

  /**
   * Print out the opening message for the player.
   */
  private void printWelcome() {
    System.out.println();
    System.out.println("Welcome to Zork!");
    System.out.println("Zork is a new, incredibly boring adventure game.");
    System.out.println("Type 'help' if you need help.");
    System.out.println();
    System.out.println(currentRoom.longDescription());
  }

  private boolean processCommand(Command command) {
    if (command.isUnknown()) {
      System.out.println("I don't know what you mean...");
      return false;
    }

    Consumer<Command> action = commandActions.get(command.getCommandWord().toLowerCase());
    if (action != null) {
      action.accept(command);
      return command.getCommandWord().equals("quit") && !command.hasSecondWord();
    } else {
      System.out.println("I don't know what you mean...");
      return false;
    }
  }

  /**
   * Print out some help information. Here we print some stupid, cryptic message
   * and a list of the command words.
   */
  private void printHelp() {
    System.out.println("You are lost. You are alone. You wander");
    System.out.println("around at Monash Uni, Peninsula Campus.");
    System.out.println();
    System.out.println("Your command words are:");
    parser.showCommands();
  }

  private void goRoom(Command command) {
    currentRoom = go.goRoom(currentRoom, command);
  }

  private void goRoom(String direction) {
    currentRoom = go.goRoom(currentRoom, direction);
  }

  private void initializeCommands() {
    commandActions.put("help", command -> printHelp());
    commandActions.put("go", this::goRoom);
    commandActions.put("quit", this::processQuit);
    commandActions.put("eat", command -> System.out.println("Do you really think you should be eating at a time like this?"));
    commandActions.put("north", command -> goRoom("north"));
    commandActions.put("south", command -> goRoom("south"));
    commandActions.put("east", command -> goRoom("east"));
    commandActions.put("west", command -> goRoom("west"));
  }

  private void processQuit(Command command) {
    if (command.hasSecondWord()) {
      System.out.println("Quit what?");
    } else {
      // Do any cleanup if necessary
    }
  }
}
