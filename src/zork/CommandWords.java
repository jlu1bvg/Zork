package zork;

import java.util.HashMap;
import java.util.Map;

public class CommandWords {
    // a constant array that holds all valid command words
    private static final String validCommands[] = {
        "go", "quit", "help", "eat", "pickup", "take", "south", "north", "west", "east",
        "open", "look", "inventory", "drop", "use", "read", "sanity", "objective", "computer", "fix"
    };

    private static final Map<String, String> commandDescriptions = new HashMap<>();

    static {
        commandDescriptions.put("go", "Move to another location");
        commandDescriptions.put("quit", "Quit the game");
        commandDescriptions.put("help", "Show available commands");
        commandDescriptions.put("eat", "Eat food to regain energy");
        commandDescriptions.put("pickup", "Pick up an item");
        commandDescriptions.put("take", "Same thing as pickup");
        commandDescriptions.put("south", "Move south");
        commandDescriptions.put("north", "Move north");
        commandDescriptions.put("west", "Move west");
        commandDescriptions.put("east", "Move east");
        commandDescriptions.put("open", "Open an object");
        commandDescriptions.put("look", "Look around for details");
        commandDescriptions.put("inventory", "Show your inventory");
        commandDescriptions.put("drop", "Drop an item");
        commandDescriptions.put("use", "Use an item");
        commandDescriptions.put("read", "Read something");
        commandDescriptions.put("write", "Write something");
        commandDescriptions.put("run", "Run to another location");
        commandDescriptions.put("talk", "Talk to someone");
        commandDescriptions.put("shout", "Shout loudly");
        commandDescriptions.put("integrate", "Integrate an item or system");
        commandDescriptions.put("sanity", "Check your sanity level");
        commandDescriptions.put("objective", "Check your current objective");
        commandDescriptions.put("computer", "Use a computer");
        commandDescriptions.put("fix", "Fix the snowcat");
    }

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. Return true if it is,
     * false if it isn't.
     **/
    public boolean isCommand(String aString) {
        for (String c : validCommands) {
            if (c.equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /*
     * Print all valid commands and their descriptions in a tabular format.
     */
    public void showAll() {
        int columns = 2;  
        int count = 0;

        System.out.println("Valid Commands:");
        System.out.println("----------------------------------------------------------------------------------------");

        for (String c : validCommands) {
            System.out.printf("%-12s: %-30s", c, commandDescriptions.get(c));  
            count++;
            if (count % columns == 0) {
                System.out.println();
            }
        }

        if (count % columns != 0) {
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }
}
