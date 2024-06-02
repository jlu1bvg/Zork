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

import zork.commands.drop;
import zork.commands.go;
import zork.commands.pickup;
import zork.commands.look;

public class Game {

  public static HashMap<String, Room> roomMap = new HashMap<>();
  private Map<String, Item> itemMap = new HashMap<>();
  private Map<String, Consumer<Command>> commandActions = new HashMap<>();

  private Parser parser;
  private static Room currentRoom;
  private static Player Jack;
  private static boolean tryToPickup;

  /**
   * Create the game and initialise its internal map
   */
  public Game() {
    try {
      initItems("src" + File.separator + "zork" + File.separator + "data" + File.separator + "items.json");
      initRooms("src" + File.separator + "zork" + File.separator + "data" + File.separator + "rooms.json");
      currentRoom = roomMap.get("Bedroom"); //change this
    } catch (Exception e) {
      e.printStackTrace();
    }
    parser = new Parser();
    initializeCommands();
    Jack = new Player(100, new Inventory(100));
    Jack.increaseInsanity(48);
    Jack.checkInsanity();
  }

  public static Player getPlayer(){
    return Jack;
  }

  private void initItems(String fileName) throws Exception {
    Path path = Path.of(fileName);
    String jsonString = Files.readString(path);
    JSONParser parser = new JSONParser();
    JSONObject json = (JSONObject) parser.parse(jsonString);

    JSONArray jsonItems = (JSONArray) json.get("items");
    if (jsonItems != null) {
        for (Object itemObj : jsonItems) {
            JSONObject jsonItem = (JSONObject) itemObj;
            String itemId = (String) jsonItem.get("id");
            String itemName = (String) jsonItem.get("name");
            String itemDescription = (String) jsonItem.get("description");
            String itemShrotDescription = (String) jsonItem.get("shortDescription");
            String weightString = (String) jsonItem.get("weight");
            double itemWeightDouble = Double.parseDouble(weightString.replace("kg", "").trim());
            int itemWeight = (int) itemWeightDouble;  // Convert to int if necessary
            boolean isOpenable = (boolean) jsonItem.get("isOpenable");
            Item item = new Item(itemWeight, itemName, itemDescription, itemShrotDescription, isOpenable);
            itemMap.put(itemId, item);
        }
    }
}

  private void initRooms(String fileName) throws Exception {
        Path path = Path.of(fileName);
        String jsonString = Files.readString(path);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);
       
        JSONArray jsonRooms = (JSONArray) json.get("rooms");
        if (jsonRooms != null) {
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

                // Check if the room has items
                JSONArray jsonItemsInRoom = (JSONArray) ((JSONObject) roomObj).get("items");
                ArrayList<Item> itemsInRoom = new ArrayList<>();
                if (jsonItemsInRoom != null) {
                    for (Object itemIdObj : jsonItemsInRoom) {
                        String itemId = (String) itemIdObj;
                        Item item = itemMap.get(itemId);
                        if (item != null) {
                            itemsInRoom.add(item);
                        }
                    }
                }
                room.setItems(itemsInRoom);

                roomMap.put(roomId, room);
            }
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
      if(tryToPickup)
        pickup(Command.getCommandWord());
      System.out.println("I don't know what you mean...");
      return false;
    }

    Consumer<Command> action = commandActions.get(Command.getCommandWord().toLowerCase());
    if (action != null) {
      action.accept(command);
      return Command.getCommandWord().equals("quit") && !command.hasSecondWord();
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

  private void pickup(Command command){
    if(Command.getSecondWord() == null){
      System.out.println("What do you want to pick up?");
      tryToPickup = true;
    }else{
      String response = pickup.pickup(Command.getSecondWord());
      System.out.println(response);
    }
  }

  public static boolean canPickup(){
    return tryToPickup;
  }

  public static void changeCanPickup(){
    tryToPickup = false;
  }

  private void pickup(String item){
      String response = pickup.pickup(item);
      System.out.println(response);
  }

  private void dropItem(Command command){
    if(Command.getSecondWord() == null){
      System.out.println("What do you want to drop?");
    }else if(Command.getSecondWord().equals("everything") || Command.getSecondWord().equals("all")){
      String response = drop.dropAll();
      System.out.println(response);
    }else{
      String response = drop.dropItem(Command.getSecondWord());
      System.out.println(response);
    }
  }

  private void lookaround(Command command){
    look.lookaround(currentRoom);
  }
  
  private void inventory(Command command){
    int nameWidth = 20;
    int weightWidth = 10;
    int isOpenableWidth = 15;

    System.out.println("Inventory:");
    System.out.printf("%-" + nameWidth + "s %" + weightWidth + "s %" + isOpenableWidth + "s\n", "Name", "Weight", "Openable");

    System.out.println(new String(new char[nameWidth + weightWidth + isOpenableWidth + 2]).replace('\0', '-'));

    for (Item item : Player.getInventory().getItems()) {
        System.out.printf("%-" + nameWidth + "s %" + weightWidth + "d %" + isOpenableWidth + "s\n", item.getName(), item.getWeight(), item.isOpenable() ? "Yes" : "No");
    }
  }

  public static Room getRoom(){
    return currentRoom;
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
    commandActions.put("pickup", this::pickup);
    commandActions.put("inventory", this::inventory);
    commandActions.put("look", this::lookaround);
    commandActions.put("drop", this::dropItem);
  }

  private void processQuit(Command command) {
    if (command.hasSecondWord()) {
      System.out.println("Quit what?");
    } else {
      // Do any cleanup if necessary
    }
  }
}