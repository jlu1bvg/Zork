package zork.commands;

import zork.Item;
// import zork.Player;
import zork.Puzzles;
import java.util.*;
import zork.Game;

public class Open {
    public static String open (String item) {
        ArrayList<Item> items = Game.getRoom().getItems();
        
        for (int i=0; i<items.size(); i++) {
            if (items.get(i).getName().equals("Typewriter")) {
                boolean isDeserving = Puzzles.manualPuzzlePaper();
                Game.changeOpen();

                if (isDeserving) {
                    // Player.getInventory().addItem(items.get(i));
                    Game.getRoom().addItem(items.get(i));
                    System.out.println("As you regain control of your body you notice a note has been typed on the typewriter.");
                } else {
                    System.out.println("As you regain control of your body you see a note however something about the note feels off.");
                }
            }
        }

        return null;
    }
}
