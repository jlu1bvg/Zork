package cityzork.src.zork.zork.commands;

import cityzork.src.zork.zork.Command;
// import cityzork.src.zork.zork.Game;
import cityzork.src.zork.zork.Utils.SoundHandler;

public class Stop extends Command{
    public Stop (String name) {
        super(name);
    }

    @Override
    public String runCommand(String... args) { // Stops the music
      SoundHandler.stop();
      return "music stopped";
    }

    
}
