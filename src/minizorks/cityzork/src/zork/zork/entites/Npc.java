package minizorks.cityzork.src.zork.zork.entites;

import minizorks.cityzork.src.zork.datatypes.Location;
import minizorks.cityzork.src.zork.zork.Entity;
import minizorks.cityzork.src.zork.zork.Inventory;
import minizorks.cityzork.src.zork.zork.Room;

public class Npc extends Entity {
    private String dialouge;

    public Npc(Location location,Room currentRoom, int health, Inventory inventory, String dialogue){
        super(location, currentRoom, health, inventory);
        this.dialouge = dialogue;
    }

    public void printDialogue(){
        System.out.println(dialouge);
    }
}
