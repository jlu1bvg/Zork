package zork.commands;

import zork.Item;
import zork.Player;
import java.util.ArrayList;
import zork.Game;

public class pickup {
    public static String pickup(String item){
        Player player = Game.getPlayer();
        ArrayList<Item> items = Game.getRoom().getItems();
        for(Item i:items){
            if(item.equals(i.getName())){
                player.getInventory().addItem(i);
                Game.getRoom().remove(i);
                return "You have picked up " + i.getName();
            }
        }
        return "Item not found";
    }
}
