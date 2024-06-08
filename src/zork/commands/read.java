package zork.commands;

import java.util.Map;

import zork.Game;
import zork.Item;

public class read {
    public static String readItem(String item) {
        Map<String, Item> items = Game.getAllItems();

        Item i = items.get(item.toLowerCase());
        
        String s = "\n" + i.getDescription() + "\n";
        return s;
    }
}
