package minizorks.whodunit.Parallel.src.zork.commands;

import minizorks.whodunit.Parallel.src.zork.Constants.ArgumentCount;
import minizorks.whodunit.Parallel.src.zork.exceptions.MinigameNotFoundException;
import minizorks.whodunit.Parallel.src.zork.proto.Command;
import minizorks.whodunit.Parallel.src.zork.proto.Item;
import minizorks.whodunit.Parallel.src.zork.threads.GameThread;
import minizorks.whodunit.Parallel.src.zork.utils.MinigameLoader;

public class Play extends Command {
    
    public Play() { super("Play", "Play a certain minigame", ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {

        String minigame = Item.arrayToString(args); // Find the minigame name

        try {
            GameThread gt = new GameThread(MinigameLoader.getMinigame(minigame)); // Game Thread

            gt.start(); 
            gt.join(); // Pause the current thread until the game is done

            Thread.sleep(1000); // Delay after the game is finished

        } catch (MinigameNotFoundException e) {
            e.printStackTrace("cmdHandler"); // If we can't find the minigame
        } catch (InterruptedException e) { 
            e.printStackTrace(); // Internal error
        }
    }
}
