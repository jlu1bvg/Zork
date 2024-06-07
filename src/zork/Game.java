package zork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.HorseRacingHelper;
import zork.commands.drop;
import zork.DDOS.DDOS;
import zork.DDOS.Folder;
import zork.commands.go;
import zork.commands.pickup;
import zork.utils.Ascii;
import zork.utils.Audio;
import zork.commands.look;
import zork.commands.objective;
import zork.commands.openItem;
import zork.commands.interact;

public class Game {

  public static HashMap<String, Room> roomMap = new HashMap<>();
  private static Map<String, Item> itemMap = new HashMap<>();
  private static ArrayList<Item> itemArray = new ArrayList<>();
  public static HashMap<String, Folder> folderMap=new HashMap<>();
  private Map<String, Consumer<Command>> commandActions = new HashMap<>();
  private static ArrayList<Room> rooms = new ArrayList<>();
  private ArrayList<Item> itemsInItem = new ArrayList<Item>();
  private Parser parser;
  private static Room currentRoom;
  private static Player Jack;
  private static boolean tryToPickup;
  private static boolean tryToOpen;
  private static boolean Objective1 = false;
  private static boolean Objective2 = false;
  private static boolean ObjectiveInsane = false;
  private DDOS computer;

  /**
   * Create the game and initialise its internal map
   */
  public Game() {
    try {
      initItems("src" + File.separator + "zork" + File.separator + "data" + File.separator + "items.json");
      initRooms("src" + File.separator + "zork" + File.separator + "data" + File.separator + "rooms.json");
        Path path = Path.of("src" + File.separator + "zork" + File.separator + "data" + File.separator + "items.json");
        String jsonString = Files.readString(path);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);

        JSONArray jsonItems = (JSONArray) json.get("items");
        for (Object itemObj : jsonItems) {
          JSONObject jsonItem = (JSONObject) itemObj;
        if (jsonItems != null) {
          String itemId = (String) jsonItem.get("id");
          initItemsinItems(itemMap.get(itemId), (JSONArray) ((JSONObject) itemObj).get("items"));
        }
      }
      currentRoom = roomMap.get("lobby"); //change this
    } catch (Exception e) {
      e.printStackTrace();
    }
    parser = new Parser();
    initializeCommands();
    Jack = new Player(100, new Inventory(20));
    // Jack.increaseInsanity(48);
    // Jack.checkInsanity();
    computer=new DDOS(parser);
  }

  public static ArrayList<Room> getRooms(){
    return rooms;
  }

  public static Map<String,Item> getAllItems(){
    return itemMap;
  }

  public static ArrayList<Item> getItemsArray(){
    return itemArray;
  }

  public static Player getPlayer(){
    return Jack;
  }

  public static boolean checkObjective1(){
    return Objective1;
  }

  public static boolean checkObjective2(){
    return Objective2;
  }

  public static boolean checkObjectiveInsane(){
    return ObjectiveInsane;
  }

  public static void changeObjective1(){
    Objective1 = true;
  }

  public static void changeObjective2(){
    Objective1 = false;
    Objective2 = true;
  }

  public static void changeObjectiveInsane(){
    Objective1 = false;
    Objective2 = false;
    ObjectiveInsane = true;
  }

  private void initItemsinItems(Item item, JSONArray jsonItemsInItem){
    //ArrayList<Item> itemsInItem = new ArrayList<Item>();
      if (jsonItemsInItem != null) {
      for (Object itemIdObj : jsonItemsInItem) {
        String id = (String) itemIdObj;
        Item i = itemMap.get(id);
        //System.out.println(i.getName());
        if (i != null) {
          itemsInItem.add(i);
        }
      }
    }
    item.setItemInventory(itemsInItem);
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
            String itemShortDescription = (String) jsonItem.get("shortDescription");
            String weightString = (String) jsonItem.get("weight");
            double itemWeightDouble = Double.parseDouble(weightString.replace("kg", "").trim());
            int itemWeight = (int) itemWeightDouble;  // Convert to int if necessary
            boolean isOpenable = (boolean) jsonItem.get("isOpenable");
            Item item = new Item(itemWeight, itemName, itemDescription, itemShortDescription, isOpenable);
            itemMap.put(itemId, item);
            itemArray.add(item);
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
                rooms.add(room);
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

  private void typeWrite(String text, int delay) {
    try {
      for (char c : text.toCharArray()) {
        System.out.print(c);
        Thread.sleep(delay); 
      }
      System.out.println();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  /**
   * Print out the opening message for the player.
   */
  private void printWelcome() {
    Audio audio = new Audio("audio", "src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Various-1980TheShiningOriginalMotionPictureSoundtrack"+File.separator+"01 - Main Title The Shining.wav");
    audio.play();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      String asciiArt = new String(Files.readAllBytes(Paths.get("src"+File.separator+"zork"+File.separator+"data"+File.separator+"KDstudios.txt")));
      Ascii.printAsciiArtWithAnimation(asciiArt);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println();

    typeWrite("You are Jack Torrance, the new caretaker of the Overlook Hotel.", 10);
    typeWrite("The hotel is isolated, surrounded by snow, and filled with dark secrets.", 10);
    typeWrite("The previous caretaker, driven mad by the hotel's eerie presence, met a gruesome end.", 10);
    typeWrite("Beware, the hotel's malevolent influence is always lurking. You can check your sanity status during the game.", 10);
    typeWrite("Explore the hotel to uncover its secrets, but tread carefully... the line between reality and madness is thin.", 10);
    typeWrite("Type 'help' if you need help.", 10);
    System.out.println();

    typeWrite(currentRoom.longDescription(), 10);

    audio.stop();
  }

  private boolean processCommand(Command command) {
    if (command.isUnknown()) {
      if(tryToPickup)
        pickup(command.getCommandWord());
      if(tryToOpen)
        open(command.getCommandWord());
        // idk what to do about the below stuff
        // null
        // I don't know what you mean...
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
    System.out.println("You are Jack Torrance. You are currently working as the caretaker for the Overlook Hotel.");
    System.out.println("The Hotel speaks to you as if you've been here before. Explore the Hotel to uncover its secrets and ominous past.");
    System.out.println();
    System.out.println("Your command words are:");
    parser.showCommands();
  }

  private void goRoom(Command command) {
    //HorseRacingHelper.clearConsole();
    currentRoom = go.goRoom(currentRoom, command);
  }

  private void goRoom(String direction) {
    //HorseRacingHelper.clearConsole();
    currentRoom = go.goRoom(currentRoom, direction);
  }

  private void pickup(Command command){
    if(command.getSecondWord() == null){
      System.out.println("\nWhat do you want to pick up?\n");
      tryToPickup = true;
    }else{
      String response = pickup.pickup(command.getSecondWord());
      System.out.println("\n" + response + "\n");
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
    if(command.getSecondWord() == null){
      System.out.println("\nWhat do you want to drop?\n");
    }else if(command.getSecondWord().equals("everything") || command.getSecondWord().equals("all")){
      String response = drop.dropAll();
      System.out.println("\n" + response + "\n");
    }else{
      String response = drop.dropItem(command.getSecondWord());
      System.out.println("\n" + response + "\n");
    }
  }

  private void lookaround(Command command){
    look.lookaround();
  }
  
  private void inventory(Command command){
    int nameWidth = 20;
    int weightWidth = 10;
    int isOpenableWidth = 15;

    System.out.println("\nInventory:");
    System.out.printf("%-" + nameWidth + "s %" + weightWidth + "s %" + isOpenableWidth + "s\n", "Name", "Weight", "Openable");

    System.out.println(new String(new char[nameWidth + weightWidth + isOpenableWidth + 2]).replace('\0', '-'));

    for (Item item : Player.getInventory().getItems()) {
        System.out.printf("%-" + nameWidth + "s %" + weightWidth + "d %" + isOpenableWidth + "s\n", item.getName(), item.getWeight(), item.isOpenable() ? "Yes" : "No");
    }
    System.out.println();
  }

  private void checkInsanity(Command command){
    Jack.checkInsanity();
  }

  private void printObjective(Command command){
    System.out.println("\n" + objective.printObjective() + "\n");
  }

  public static Room getRoom(){
    return currentRoom;
  }

  public void openItem(Command command){
    System.out.println(openItem.openItem(command.getSecondWord()));
  }

  private void runDDOS(Command command){
    try {
      computer.runDDOS();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  // public void playPuzzle() {
  //   if ()
  //   //check which item is open
  //   //play the puzzle
  //   //...
  // }

  public void open(Command command) {
    if(command.getSecondWord() == null){
      System.out.println("\nWhat do you want to open?\n");
      tryToOpen = true;
    }else {
      String response = openItem.openItem(command.getSecondWord());
      System.out.println("\n" + response + "\n");
    }
  }

  public void open(String item){
    String response = openItem.openItem(item);
    System.out.println(response);
}

  public static void changeOpen() {
    tryToOpen = false;
  }

  public void interact(Command command) {
    if(command.getSecondWord() == null){
      System.out.println("\nWhat do you want to interact with?\n");
    }else {
      interact.interactWithItem(command.getSecondWord());
    }
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
    commandActions.put("take", this::pickup);
    commandActions.put("inventory", this::inventory);
    commandActions.put("look", this::lookaround);
    commandActions.put("drop", this::dropItem);
    commandActions.put("objective", this::printObjective);
    commandActions.put("sanity", this::checkInsanity);
    commandActions.put("computer", this::runDDOS);
    commandActions.put("open", this::openItem);
    commandActions.put("drive", this::interact);
  }

  private void processQuit(Command command) {
    if (command.hasSecondWord()) {
      System.out.println("Quit what?");
    } else {
      // Do any cleanup if necessary
    }
  }
}