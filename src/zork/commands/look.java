package zork.commands;

import zork.Game;
import zork.Item;
import java.util.ArrayList;

public class look {
    public static void lookaround(){
        ArrayList<Item> items = Game.getRoom().getItems();
        System.out.println(Game.getRoom().shortDescription());
        if(items.size()>1){
            System.out.print("You see ");
            for (int i = 0; i < items.size(); i++) {
                if(items.get(i).getName().equalsIgnoreCase("snowcat"))
                    Game.changeObjective1();
                if(i == items.size()-1){
                    System.out.print("and a " + items.get(items.size()-1).getName() + ".");
                    break;
                }
                System.out.print("a " + items.get(i).getName() + ", ");
            }
            System.out.println();
        }else if (items.size() == 1){
            if(items.get(0).getName().equalsIgnoreCase("snowcat"))
                    Game.changeObjective1();
            System.out.println("You see a " + items.get(0).getName());
        }
        System.out.println();
    }
}
