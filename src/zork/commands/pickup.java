package zork.commands;

import zork.Item;
import zork.Player;
import java.util.ArrayList;
import zork.Game;

public class pickup {
    public static String pickup(String item){
        Player player = Game.getPlayer();
        ArrayList<Item> items = Game.getRoom().getItems();
        if(item.equalsIgnoreCase("snowcat"))
            return "Did you really try to pickup a Snowcat...?";

        for(Item i:items){
            if(item.equalsIgnoreCase(i.getName())){
                player.getInventory().addItem(i);
                Game.getRoom().remove(i);
                if(item.equalsIgnoreCase("snowcat repair manual")){
                    Game.changeObjective2();
                    Player.getInventory().removeItem(i);
                    return "You have picked up " + i.getDescription();
                }
                return "You have picked up " + i.getDescription();
            }
        }
        if(items.size()>1){
            String listOfItems = "";
            for (int i = 0; i < items.size(); i++) {
                if(i == items.size()-1){
                    listOfItems += "and " + items.get(items.size()-1).getName() + ".";
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

    public static String pickupItemInItem(String item){
        Player player = Game.getPlayer();
        ArrayList<Item> items = Game.getItemsArray();
        for(Item i:items){
            if(item.equalsIgnoreCase(i.getName())){
                player.getInventory().addItem(i);
                Game.getRoom().remove(i);
                if(item.equalsIgnoreCase("snowcat repair manual")){
                    Game.changeObjective2();
                    Player.getInventory().removeItem(i);
                    return "You have picked up " + i.getDescription();
                }
                return "You have picked up " + i.getDescription();
            }
        }
        if(items.size()>1){
            String listOfItems = "";
            for (int i = 0; i < items.size(); i++) {
                if(i == items.size()-1){
                    listOfItems += "and " + items.get(items.size()-1).getName() + ".";
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
