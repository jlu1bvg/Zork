package minizorks.whodunit.Parallel.src.zork.commands;

import minizorks.whodunit.Parallel.src.zork.Game;
import minizorks.whodunit.Parallel.src.zork.Constants.ArgumentCount;
import minizorks.whodunit.Parallel.src.zork.proto.Command;

public class Quit extends Command{

    public Quit() {
        super("Quit", "Quits the game", ArgumentCount.INFINITE);
    }

    @Override
    public void runCommand(String... args) {
        Game.quitGame();
    }
    
}
