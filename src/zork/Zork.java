package zork;

public class Zork {
  public static void main(String[] args) {
    // Game game = new Game();
    // game.play();
    // MapHorseRacing.runMapHorseRace(); //npc moving not working so basically unusable
    // OtherHorseRacing.runOtherHorseRace(); //not compatible with anything but works
    // MultiHorseRacing.runMultiHorseRace();
    Bootstrapper.runMultiHorseRacing();
    Bootstrapper.runCityZork();
  }
}
