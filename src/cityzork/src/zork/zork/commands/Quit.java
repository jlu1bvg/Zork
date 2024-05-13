package cityzork.src.zork.zork.commands;

import cityzork.src.zork.zork.Command;
import cityzork.src.zork.zork.Game;

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
