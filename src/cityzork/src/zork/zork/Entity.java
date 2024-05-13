package cityzork.src.zork.zork;


import java.util.ArrayList;

import cityzork.src.zork.datatypes.Location;

public abstract class Entity {
    private Location location;
    private Room currentRoom;
    private int health;
    private Inventory inventory;

    public Entity(Location location, Room currentRoom, int health, Inventory inventory){
        this.currentRoom = currentRoom;
        this.location = location;
        this.health = health;
        this.inventory = inventory;
    }

    public Entity(Location location, Room currentRoom, int health) {
        this.currentRoom = currentRoom;
        this.location = location;
        this.health = health;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void create() {
        
    }

    public int getWeight() {
        ArrayList<Item> arr = Game.getGame().getPlayer().getInventory().getItems();
        int weight = 0;
        for(int i = 0; i<arr.size(); i++){
            weight+= arr.get(i).getWeight();
        }
        return weight;
    }





}
