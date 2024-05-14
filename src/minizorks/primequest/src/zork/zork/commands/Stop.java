package minizorks.primequest.src.zork.zork.commands;

import minizorks.primequest.src.zork.zork.Command;
import minizorks.primequest.src.zork.zork.Utils.SoundHandler;

public class Stop extends Command{
    public Stop (String name) {
        super(name);
    }

    @Override
    public String runCommand(String... args) { // Stops the music
      SoundHandler.stop();
      return "music stopped";
    }

    public static void runCommand(){
      SoundHandler.stop();
    }

    
}
