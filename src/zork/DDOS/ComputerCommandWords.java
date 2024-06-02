package zork.DDOS;

public class ComputerCommandWords {
  // a constant array that holds all valid command words
  private static final String validCommands[] = {"dir", "clear", "help", "exit"};
  private static final String validMultiCommands[]={"cd"};

  /**
   * Constructor - initialise the command words.
   */
  public ComputerCommandWords() {
    // nothing to do at the moment...
  }

  /**
   * Check whether a given String is a valid command word. Return true if it is,
   * false if it isn't.
   **/
  public boolean isSingleCommand(String aString) {
    for (String c : validCommands) {
      if (c.equals(aString))
        return true;
    }
    // if we get here, the string was not found in the commands
    return false;
  }

  public boolean isMultiCommand(String string){
    for(String command:validMultiCommands){
      if(command.equals(string)){
        return true;
      }
    }
    return false;
  }

  /*
   * Print all valid commands to System.out.
   */
  public void showAll() {
    for (String c : validCommands) {
      System.out.print(c + "  ");
    }
    System.out.println();
  }

  public void printHelp(){
    System.out.println("help - Shows all commands\n"+
    "clear - Clears the consolen\n"+
    "dir - Shows contents of current folder\n"+
    "cd <folder> - Opens given folder, '..' to go back\n"+
    "<fileName> - Opens given file");
  }
}
