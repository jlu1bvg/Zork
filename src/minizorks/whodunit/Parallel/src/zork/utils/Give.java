package minizorks.whodunit.Parallel.src.zork.utils;

import minizorks.whodunit.Parallel.src.zork.Game;
import minizorks.whodunit.Parallel.src.zork.exceptions.InventoryLimitExceeded;
import minizorks.whodunit.Parallel.src.zork.proto.Item;

public class Give {
    public static boolean giveItem(Item item, String cName) {
        try {
            Game.player.getInventory().addItem(item);

            if(cName != null) { Game.print("/bThe " + cName + " gave you " + item.getName() + "!"); }
            return true;
        } catch(InventoryLimitExceeded e) {
            Game.print("/bPlease make space in your inventory to recieve " + item.getName());
            return false;
        }
    }
}
