package zork.commands;

import zork.Game;
import zork.Item;
import zork.Room;
import java.util.ArrayList;

public class look {
    public static void lookaround(Room room){
        ArrayList<Item> items = Game.getRoom().getItems();
        System.out.println(Game.getRoom().longDescription());
        if(items.size()>1){
            System.out.print("You see ");
            for (int i = 0; i < items.size(); i++) {
                if(i == items.size()-1){
                    System.out.print("and " + items.get(items.size()-1).getShortDescription() + ".");
                    break;
                }
                System.out.print(items.get(i).getShortDescription() + ", ");
            }
            System.out.println();
        }else if (items.size() == 1){
            System.out.println("You see " + items.get(0).getShortDescription());
        }
    }
}
