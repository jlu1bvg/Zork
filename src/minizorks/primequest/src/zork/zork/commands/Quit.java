package minizorks.primequest.src.zork.zork.commands;

import minizorks.primequest.src.zork.zork.Command;
import minizorks.primequest.src.zork.zork.Game;

public class Quit extends Command{
        public Quit(String name) {
        super(name);
        addAlias("quit game");
    }

    @Override
    public String runCommand(String... args){
        Game.changeFinished(true);
        return "";
    }
}
