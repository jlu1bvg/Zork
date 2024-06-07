package zork.commands;

import zork.Item;
import zork.Player;
import zork.Puzzles;

import java.util.*;
import zork.Game;

public class Open {
    public static String open (String item) {
        if (item.equals("telephone")) {
            boolean isDeserving = Puzzles.manualPuzzlePaper();

            if (isDeserving) {
                
            } else {
                System.out.println("As you regain control of your body you feel as if you have missed something crucial");
            }
        }
        return null;
    }
}
