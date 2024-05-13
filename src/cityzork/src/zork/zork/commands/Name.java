package cityzork.src.zork.zork.commands;

import cityzork.src.zork.zork.Command;
import cityzork.src.zork.zork.Game;

public class Name extends Command {
    public Name(String name) {
        super(name);
    }

    @Override
    public String runCommand(String... args) { // Returns the player's name
        return "Your name is" + Game.getGame().getPlayer().getName();
    }

    
}

