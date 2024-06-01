package zork;

public class Player {

    private Room currentRoom;
    private int health;
    private Inventory inventory;

    public Player (Room room, int hp, Inventory i){
        currentRoom = room;
        health = hp;
        inventory = i;
    }

    
}
