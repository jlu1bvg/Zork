package zork;

import horseracers.maphorserace.HorseRacingAssignment.src.horseracing.MapHorseRacing;
import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.MultiHorseRacing;
import minizorks.cityzork.src.zork.zork.CityZork;

public class Bootstrapper {
    public static void runMultiHorseRacing(){
         MultiHorseRacing.runMultiHorseRace();
    }
    
    public static void runCityZork(){
        try {
            CityZork.runCityZork();
        } catch (InterruptedException e) {
            e.printStackTrace();
    }
    }
    public static void runMapHorseRacing(){
        MapHorseRacing.runMapHorseRace();
    }
}
