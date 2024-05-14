package minizorks.whodunit.Parallel.src.zork.threads;

import minizorks.whodunit.Parallel.src.zork.exceptions.CommandNotFoundException;
import minizorks.whodunit.Parallel.src.zork.utils.CommandContext;
import minizorks.whodunit.Parallel.src.zork.utils.Parser;
import minizorks.whodunit.Parallel.src.zork.Game;

public class CommandListener extends Thread {
    public CommandListener() {
        super("CmdListener");
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("--------------");
                
                CommandContext res = Parser.getCommand();

                System.out.println("--------------");

                res.runCommand();
            } catch (CommandNotFoundException e) {
                e.printStackTrace(getName());
            }
        }
    }
}