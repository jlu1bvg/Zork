package minizorks.primequest.src.zork.zork.commands;

import minizorks.primequest.src.zork.zork.Command;
import minizorks.primequest.src.zork.zork.Utils;

public class Skip extends Command {

    public Skip(String name) {
        super(name);
    }

    @Override
    public String runCommand(String... args) throws InterruptedException { // Skips the song currently playing
        Utils.SoundHandler.skip();
        return "Skipped!";
    }
    
}
