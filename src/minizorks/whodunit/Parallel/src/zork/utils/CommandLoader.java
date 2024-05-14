package minizorks.whodunit.Parallel.src.zork.utils;

import java.util.*;

import minizorks.whodunit.Parallel.src.zork.exceptions.CommandNotFoundException;
import minizorks.whodunit.Parallel.src.zork.proto.Command;

public class CommandLoader {
    private static final Map<String, Command> commands = new HashMap<>();

    public static void init() {
        try {
            Class<?>[] classes = Loader.getClasses("minizorks.whodunit.Parallel.src.zork.commands");

            for (Class<?> c : classes) {
                commands.put(c.getSimpleName().toLowerCase(), (Command) c.getConstructors()[0].newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    public static Map<String, Command> getAllCommands() {
        return commands;
    }

    public static Command getCommand(String n) throws CommandNotFoundException {
        Command c = commands.get(n.toLowerCase());

        if (c == null) 
            throw new CommandNotFoundException(n);

        return c;
    }
}
