package cityzork.src.zork.zork.commands;

import cityzork.src.zork.zork.Command;
import cityzork.src.zork.zork.Game;

public class Where extends Command {
    public Where(String name) {
        super(name);
    }

    @Override
    public String runCommand(String... args) { // Says the name of the room
        return Game.getGame().getPlayer().getCurrentRoom().getDisplayName();
    }

    
    
}
