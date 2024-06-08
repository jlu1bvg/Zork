package zork.commands;

import zork.Item;
import zork.Player;
// import zork.Player;
import zork.Puzzles;
import java.util.*;
import zork.Game;

public class openPuzzle {
    public static String openPuzz (String item) {
        //FIX NEEDED: THE CHEST AND TELEPHONE OPENS BUT THE ITEMS ARE OUTSIDE OF THEM
        // ArrayList<Item> items = Game.getRoom().getItems();
        // Game.changeOpenPuzzle();
        String piece = item;

        if(piece.equalsIgnoreCase("typewriter")) {
        // for (int i=0; i<items.size(); i++) {
        //     if (items.get(i).getName().equals("Typewriter")) {
                boolean isDeserving = Puzzles.manualPuzzlePaper();

                if (isDeserving) {
                    // Player.getInventory().addItem(items.get(i));
                    Game.getRoom().addItem(Game.getAllItems().get("manual_key_paper"));
                    System.out.println("As you regain control of your body you notice a note has been typed on the typewriter.");
                } else {
                    System.out.println("As you regain control of your body you see a note however something about the note feels off.");
                }
            } else if (piece.equalsIgnoreCase("chest")){ //works with one word
                boolean isDeserving = Puzzles.manualPuzzleChest();

                if (isDeserving) {
                    Game.getAllItems().get("chest").setOpenable(true);
                    Game.getRoom().addItem(Game.getAllItems().get("snowcat_manual"));
                    System.out.println("to your surprise the chest swings open. Inside you see a dusty old booklet.");
                } else {
                    System.out.println("It seems the combination entered is incorrect.");
                }
            } else if (piece.equalsIgnoreCase("telephone")){ //works with one word
                Player.getInventory().addItem(Game.getAllItems().get("screwdriver"));
                boolean isDeserving = Puzzles.wires();

                if (isDeserving) {
                    Game.getAllItems().get("telephone").setOpenable(true);
                    Game.getRoom().addItem(Game.getAllItems().get("red wire"));
                    System.out.println("taking off the bottom of the telephone you spot a bright red wire.");
                } else {
                    System.out.println("your clumsy attempt to open the telephone was unfruitful.");
                }
            } else {
                System.out.println("I don't know what you mean...");
            }
        //     }
        // }

        return " ";
    }
}
