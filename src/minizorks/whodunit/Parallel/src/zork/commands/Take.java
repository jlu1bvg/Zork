package minizorks.whodunit.Parallel.src.zork.commands;

import minizorks.whodunit.Parallel.src.zork.Game;
import minizorks.whodunit.Parallel.src.zork.Constants.ArgumentCount;
import minizorks.whodunit.Parallel.src.zork.proto.Command;
import minizorks.whodunit.Parallel.src.zork.proto.Inventory;
import minizorks.whodunit.Parallel.src.zork.proto.Item;
import minizorks.whodunit.Parallel.src.zork.exceptions.InventoryLimitExceeded;
import minizorks.whodunit.Parallel.src.zork.exceptions.ItemNotFoundException;

public class Take extends Command {

    public Take() { super("Take", "Put an item from the room into your inventory", ArgumentCount.INFINITE); }

    public void runCommand(String... args) {
        for (Item item : Game.player.getCurrentRoom().getRoomItems().getContents()) { // Iterate over the inventory
            if (Item.arrayToString(args).equalsIgnoreCase(item.getName())) { // Check if we found the rigth one
                Inventory inv_receive = Game.player.getInventory(); // Our Inventory
                Inventory inv_take = Game.player.getCurrentRoom().getRoomItems(); // The room's "inventory"
                
                try {
                    inv_receive.addItem(item); // Throws InventoryLimitExceeded if we cannot fit the item
                    inv_take.removeItem(item); // Removes after, just in case an exception is thrown; we don't want to remove something from the room if we fail to pick it up
                } catch (InventoryLimitExceeded e) {
                    e.printStackTrace();
                    return;
                }

                Game.print("/bYou picked up a " + item.getName() + " from the ground."); // Informs the player
                return;
            }
        }

        try {
            throw new ItemNotFoundException(Item.arrayToString(args)); // If this is reached, something is wrong with the item name, or we just don't have it
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
    }
}