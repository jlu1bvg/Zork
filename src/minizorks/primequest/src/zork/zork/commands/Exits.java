package minizorks.primequest.src.zork.zork.commands;

import minizorks.primequest.src.zork.zork.Command;
import minizorks.primequest.src.zork.zork.Exit;
import minizorks.primequest.src.zork.zork.Game;

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
