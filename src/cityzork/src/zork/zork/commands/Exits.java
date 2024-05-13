package cityzork.src.zork.zork.commands;

import cityzork.src.zork.zork.Command;
import cityzork.src.zork.zork.Exit;
import cityzork.src.zork.zork.Game;

public class Exits extends Command {
    public Exits(String name) {
        super(name);
        addAlias("ex");
    }

    @Override
    public String runCommand(String... args) {
        String ans = "";
        for(Exit e : Game.getGame().getPlayer().getCurrentRoom().getExits()) {
            ans = ans + e.getDirection() + " " + e.getAdjacentRoom().getRoomName() + "\n";
        }
        return ans;    
    }

    
}
