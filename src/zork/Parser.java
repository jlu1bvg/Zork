package zork;

import java.util.Scanner;

import zork.DDOS.ComputerCommand;
import zork.DDOS.ComputerCommandWords;
import zork.DDOS.Folder;

public class Parser {
  private CommandWords commands; // holds all valid command words
  private ComputerCommandWords computerCommands;
  private Scanner in;

  public Parser() {
    commands = new CommandWords();
    computerCommands=new ComputerCommandWords();
    in = new Scanner(System.in);
  }

  public Command getCommand() throws java.io.IOException {
    String inputLine = "";
    String[] words;

    System.out.print("> "); // print prompt

    inputLine = in.nextLine();

    words = inputLine.split(" ");

    String word1 = words[0];
    String word2 = null;
    if (words.length > 1)
      word2 = words[1];
    if (commands.isCommand(word1.toLowerCase()))
      return new Command(word1, word2);
    else
      return new Command(null, word2);
  }

  public ComputerCommand getComputerCommand(Folder currentFolder) throws java.io.IOException {
    String inputLine = "";
    String[] words;

    System.out.print(currentFolder.getFolderPath()+"> "); // print prompt

    inputLine = in.nextLine();

    words = inputLine.split(" ");

    String word1 = words[0];
    String word2 = null;
    if (words.length > 1){
      word2 = words[1];
      if(computerCommands.isMultiCommand(word1)){
        return new ComputerCommand(word1, word2);
      }
    }
    if (computerCommands.isSingleCommand(word1.toLowerCase())&&word2==null)
      return new ComputerCommand(word1, null);
    else if(currentFolder.checkFile(word1))
      return new ComputerCommand("open", word1);
    else
      return new ComputerCommand(null, null);
  }

  /**
   * Print out a list of valid command words.
   */
  public void showCommands() {
    commands.showAll();
  }

  public void showComputerCommands(){
    computerCommands.printHelp();
  }
}
