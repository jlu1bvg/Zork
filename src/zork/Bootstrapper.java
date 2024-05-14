package zork;

import cityzork.src.zork.zork.CityZork;
import horseracers.maphorserace.HorseRacingAssignment.src.horseracing.MapHorseRacing;
import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.MultiHorseRacing;

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
