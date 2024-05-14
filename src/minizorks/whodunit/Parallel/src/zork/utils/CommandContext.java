package minizorks.whodunit.Parallel.src.zork.utils;

import minizorks.whodunit.Parallel.src.zork.exceptions.CommandNotFoundException;
import minizorks.whodunit.Parallel.src.zork.proto.Command;

public class CommandContext {
    private final Command command;
    private final String[] args;

    public CommandContext(String commandName) throws CommandNotFoundException {       
        command = CommandLoader.getCommand(commandName);
        args = null;
    }

    public CommandContext(String commandName, String... arguments) throws CommandNotFoundException {
        command = CommandLoader.getCommand(commandName);
        args = arguments;
    }


    public void runCommand(String... specialArgs) {
        if (!command.checkArgs(args)) {
            throw new IllegalArgumentException(String.format("Invalid amount of arguments (expected %d, got %d)", command.argumentLimit.argCount(), args.length));
        }

        if (specialArgs.length != 0) {
            command.runCommand(specialArgs);
        } else {
            command.runCommand(args);
        }
    }

}
