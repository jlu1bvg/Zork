package minizorks.whodunit.Parallel.src.zork.threads;

import minizorks.whodunit.Parallel.src.zork.exceptions.CommandNotFoundException;
import minizorks.whodunit.Parallel.src.zork.utils.CommandContext;
import minizorks.whodunit.Parallel.src.zork.utils.Parser;
import minizorks.whodunit.Parallel.src.zork.Game;
import minizorks.whodunit.Parallel.src.zork.utils.Stopper;

public class CommandListener extends Thread {
    public CommandListener() {
        super("CmdListener");
    }

    @Override
    public void run() {
        Stopper stopper = new Stopper();
        while (!stopper.getStopped()) {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("--------------");
                    CommandContext res = Parser.getCommand("");
                    System.out.println("--------------");
                    res.runCommand();
                }
            } catch (CommandNotFoundException e) {
                e.printStackTrace(getName());
            }
        }
    }
}