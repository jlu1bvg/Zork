package minizorks.whodunit.Parallel.src.zork.proto;

import minizorks.whodunit.Parallel.src.zork.Game;

import java.util.Scanner;

public class Player {
    private final Inventory playerInventory;
    private Room currentRoom;
    private String name;
    private boolean wonMinigame;
    
    public Player(int inventoryLimit) {
        playerInventory = new Inventory(inventoryLimit);
        currentRoom = Game.roomMap.get("userRoom");
    }

    public Player(String room, int inventoryLimit) {
        playerInventory = new Inventory(inventoryLimit);
        currentRoom = Game.roomMap.get(room);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String s) {
        currentRoom = Game.roomMap.get(s);
    }

    public Inventory getInventory() {
        return playerInventory;
    }

    public void setPlayerName() {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        name = in.nextLine();
    }

    public void setPlayerName(int n) {
        name = "Cameron";
    }

    public String getPlayerName() {
        return this.name;
    }

    public void setResult(boolean b) {
        wonMinigame = b;
    }

    public boolean getResult() {
        return wonMinigame;
    }
}
