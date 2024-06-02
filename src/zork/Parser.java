package zork;

import java.util.Scanner;

import zork.DDOS.ComputerCommand;
import zork.DDOS.ComputerCommandWords;

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

  public ComputerCommand getComputerCommand() throws java.io.IOException {
    String inputLine = "";
    String[] words;

    System.out.print("C:\\Users\\StuartUllman> "); // print prompt

    inputLine = in.nextLine();

    words = inputLine.split(" ");

    String word1 = words[0];
    String word2 = null;
    if (words.length > 1)
      word2 = words[1];
    if (computerCommands.isCommand(word1.toLowerCase()))
      return new ComputerCommand(word1, word2);
    else
      return new ComputerCommand(null, word2);
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
