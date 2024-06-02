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
        return "Item not found in inventory";
    }

    public static String dropAll(){
        Player player = Game.getPlayer();
        ArrayList<Item> items = Player.getInventory().getItems();
        for (int i = items.size()-1; i >= 0; i--) {
            Game.getRoom().addItem(items.get(i));
            player.getInventory().removeItem(items.get(i));
        }
        return "You dropped everything.";
    }
}