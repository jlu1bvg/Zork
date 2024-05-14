package minizorks.whodunit.Parallel.src.zork.threads;

import minizorks.whodunit.Parallel.src.zork.proto.Minigame;

public class GameThread extends Thread {
    private final Minigame game;

    public GameThread(Minigame game) {
        super(String.format("GameThread [%s]", game.getHash()));

        this.game = game;
    }  

    @Override

    public void run() {
        game.startGame();
    }
}
