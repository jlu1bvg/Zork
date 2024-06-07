package zork.commands;

import zork.Item;
import zork.Inventory;
import zork.Game;
import zork.Player;
import zork.commands.pickup;
import java.util.Map;

public class open {
    public static String openItem(String item){
        Map<String, Item> items = Game.getAllItems();
        Item i = items.get(item.toLowerCase());
        String s = "";
        if(i.getItemInventory() != null){
            for(Item x : i.getItemInventory()){
                s += "\n" + pickup.pickupItemInItem(x.getName().toLowerCase()) + "\n";
            }
        }
        return s;
    }
}