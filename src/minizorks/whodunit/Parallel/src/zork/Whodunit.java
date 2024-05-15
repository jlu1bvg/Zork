package minizorks.whodunit.Parallel.src.zork;

import minizorks.whodunit.Parallel.src.zork.exceptions.CommandNotFoundException;

public class Whodunit {
    public static void runWhodunit() throws InterruptedException, CommandNotFoundException{
        Game game = Game.getCurrentGame();
        game.play(false);
    }
}
// cee itch ong
// :nerdemoji: