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
                return "You have picked up " + i.getDescription();
            }
        }
        if(items.size()>1){
            System.out.println("Item not found");
            String listOfItems = "";
            for (int i = 0; i < items.size()-1; i++) {
                if(i == items.size()-1){
                    listOfItems += items.get(items.size()-1) + ".";
                    break;
                }
                listOfItems += items.get(i).getName() + ", ";
            }
            return "Item not found. You can pickup " + listOfItems;
        }else if(items.size() == 1){
            return "Item not found. You can pickup " + items.get(0).getName();
        }
        return "Item not found";
    }
}
