package zork.commands;

import zork.Puzzles;
import zork.Game;
import zork.Player;


public class openPuzzle {
    public static String openPuzz (String item) {

        if (item.equalsIgnoreCase("typewriter")) {
            boolean isDeserving = Puzzles.manualPuzzlePaper();

            if (isDeserving) {
                Game.getRoom().addItem(Game.getAllItems().get("manual_key_paper"));
                System.out.println("As you regain control of your body you notice a note has been typed on the typewriter.");
            } else {
                System.out.println("As you regain control of your body you see a note however something about the note feels off.");
            }

        } else if (item.equalsIgnoreCase("chest")){

            boolean isDeserving = Puzzles.manualPuzzleChest();

            if (isDeserving) {
                Game.getAllItems().get("chest").setOpenable(true);
                System.out.println("to your surprise the chest swings open. Inside you see a dusty old booklet.");
            } else {
                System.out.println("It seems the combination entered is incorrect.");
            }

        } else if (item.equalsIgnoreCase("telephone")){

            boolean isDeserving = Puzzles.wires();

            if (isDeserving) {
                Game.getAllItems().get("telephone").setOpenable(true);
                System.out.println("taking off the bottom of the telephone you spot some wires.");
            } else {
                System.out.println("your clumsy attempt to open the telephone was unfruitful.");
            }

        } else if (item.equalsIgnoreCase("circuit")){

            boolean isDeserving = Puzzles.engine();

            if (isDeserving) {
                Game.getRoom().addItem(Game.getAllItems().get("snowcat_engine_part"));
                System.out.println("you hear a loud bang in the room and next to you appears a snowcat engine.");
            } else {
                System.out.println("not all the switches have been flipped? Maybe if you try again it might work?");
            }

        } else if (item.equalsIgnoreCase("ice block")){

            boolean isDeserving = Puzzles.fuelCan();

            if (isDeserving) {
                Game.getRoom().addItem(Game.getAllItems().get("fuel_can"));
                System.out.println("you melt the ice away revealing a perfectly preserved jug of fuel for the snowcat.");
            } else {
                System.out.println("as you attempt to remember the word for the picture in your mind, the picture slowly fades from your mind");
            }
            
        } else {
            System.out.println("I don't know what you mean...");
        }

        return " ";
    }
}
