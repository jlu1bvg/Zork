package cityzork.src.zork.zork;

import java.util.ArrayList;

public class Command {
  private String name;
  private ArrayList<String> aliases = new ArrayList<>();

  /**
   * Create a command object. Only need to supply the name and then use override the
   * runCommand method for it to actually do stuff.
   */
  public Command(String name) {
    this.name = name;
  }

  /**
   * Adds an alias to this command.
   * @param The name to be added as an alias.
   */
  public Command addAlias(String name) {
    aliases.add(name);
    return this;
  }

  /**
   * Gets all aliases for this command.
   * @return The aliases.
   */
  public ArrayList<String> getAliases() {
    return aliases;
  }

  /* Blank constructor for unknown commands. */
  public Command() {
    this.name = "Unknown";
  }

  
  /**
   * 
   * @param args
   * @return Console otuput
   * @throws InterruptedException
   */
  public String runCommand(String... args) throws InterruptedException  {
    return "Invalid command: " + name;
  }

  /**
   * @return name of Command
   */
  public String getName() {
    return name;
  }

}
