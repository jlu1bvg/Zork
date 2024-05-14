package minizorks.whodunit.Parallel.src.zork.commands;

import minizorks.whodunit.Parallel.src.zork.Constants.ArgumentCount;
import minizorks.whodunit.Parallel.src.zork.proto.Command;

public class Omch extends Command {

    public Omch() { super("Omch", "OMCH!", ArgumentCount.ONE); }

    public void runCommand(String... args) {
        System.out.printf("Hi I'm a %s and my name is Omch!\n", args[0]); // OMCH!
    }

}
