package minizorks.whodunit.Parallel.src.zork;

import minizorks.whodunit.Parallel.src.zork.exceptions.CommandNotFoundException;

public class Test {
    public static void main(String[] args) throws InterruptedException, CommandNotFoundException {
        Game game = Game.getCurrentGame();
        game.play(true);
    }
}
