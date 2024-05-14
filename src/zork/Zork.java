package zork;

import minizorks.whodunit.Parallel.src.zork.Whodunit;

public class Zork {
  public static void main(String[] args) {
    // Game game = new Game();
    // game.play();
    // MapHorseRacing.runMapHorseRace(); //npc moving not working so basically unusable
    // OtherHorseRacing.runOtherHorseRace(); //not compatible with anything but works
    // MultiHorseRacing.runMultiHorseRace();
    // Bootstrapper.runMultiHorseRacing();
    // Bootstrapper.runPrimequest();
    try {
      Whodunit.runWhodunit();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // Bootstrapper.runPrimequest();
  }
}
