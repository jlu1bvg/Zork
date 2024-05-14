package minizorks.cityzork.src.zork.zork.commands;

import minizorks.cityzork.src.zork.zork.Command;
import minizorks.cityzork.src.zork.zork.Utils.SoundHandler;

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
