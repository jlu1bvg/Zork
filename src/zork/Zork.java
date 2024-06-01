package zork;

public class Zork {
  public static void main(String[] args) throws InterruptedException {
    // Game game = new Game();
    // game.play();
    // MapHorseRacing.runMapHorseRace(); //npc moving not working so basically unusable
    // OtherHorseRacing.runOtherHorseRace(); //not compatible with anything but works
    // MultiHorseRacing.runMultiHorseRace();
    // Bootstrapper.runMultiHorseRacing();
    // Bootstrapper.runPrimequest();
    // Bootstrapper.runPrimequest();
    // Bootstrapper.runUndertale();
    // Bootstrapper.runWhodunit();
    // Bootstrapper.runPrimequest();
    // Bootstrapper.runZork(); 
    Parser parser=new Parser();
    DDOS.runDDOS(parser);
  }
}
