package zork;
import cityzork.src.zork.zork.CityZork;
import horseracers.maphorserace.src.horseracing.MapHorseRacing;
import horseracers.multihorserace.src.horseracing.MultiHorseRacing;
import horseracers.otherhorserace.src.horseracing.OtherHorseRacing;

public class Zork {
  public static void main(String[] args) {
    // Game game = new Game();
    // game.play();
    // MapHorseRacing.runMapHorseRace(); //npc moving not working so basically unusable
    // OtherHorseRacing.runOtherHorseRace(); //not compatible with anything but works
    // MultiHorseRacing.runMultiHorseRace();
    try {
      CityZork.runCityZork();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    MultiHorseRacing.runMultiHorseRace();
  }
}
