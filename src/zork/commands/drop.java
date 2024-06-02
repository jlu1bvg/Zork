package zork.commands;

import zork.Item;
import zork.Player;
import java.util.ArrayList;
import zork.Game;

public class drop {
    public static String dropItem(String item){
        Player player = Game.getPlayer();
        ArrayList<Item> items = Player.getInventory().getItems();
        for(Item i:items){
            if(item.equals(i.getName())){
                Game.getRoom().addItem(i);
                player.getInventory().removeItem(i);
                return "You dropped " + i.getName();
            }
        }
        return "Item not found";
    }
}
