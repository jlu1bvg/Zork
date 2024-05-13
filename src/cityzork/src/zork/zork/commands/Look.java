package cityzork.src.zork.zork.commands;

import java.io.IOException;

import cityzork.src.zork.zork.Command;
import cityzork.src.zork.zork.Game;

public class Look extends Command {
    public Look(String name) {
        super(name);
        addAlias("l");
    }

    @Override
    public String runCommand(String... args) { // Prints the ascii, room name and the description
        try {
            Game.getGame().getPlayer().getCurrentRoom().printAscii();
        } catch (IOException e) {
            System.err.println("Graphics Couldn't Load");
        }
        return Game.getGame().getPlayer().getCurrentRoom().shortDescription();

    }

    
}
