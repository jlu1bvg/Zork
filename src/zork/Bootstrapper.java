package zork;

import horseracers.maphorserace.HorseRacingAssignment.src.horseracing.MapHorseRacing;
import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.MultiHorseRacing;
import minizorks.primequest.src.zork.zork.Primequest;

public class Bootstrapper {
    public static void runMultiHorseRacing(){
         MultiHorseRacing.runMultiHorseRace();
    }
    
    public static void runPrimequest(){
        try {
            Primequest.runPrimequest();
        } catch (InterruptedException e) {
            e.printStackTrace();
    }
    }
    public static void runMapHorseRacing(){
        MapHorseRacing.runMapHorseRace();
    }
}
