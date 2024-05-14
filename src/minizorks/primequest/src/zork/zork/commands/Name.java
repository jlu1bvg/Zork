package minizorks.primequest.src.zork.zork.commands;

import minizorks.primequest.src.zork.zork.Command;
import minizorks.primequest.src.zork.zork.Game;

public class Name extends Command {
    public Name(String name) {
        super(name);
    }

    @Override
    public String runCommand(String... args) { // Returns the player's name
        return "Your name is" + Game.getGame().getPlayer().getName();
    }

    
}

