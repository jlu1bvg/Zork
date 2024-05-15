package zork;

import horseracers.maphorserace.HorseRacingAssignment.src.horseracing.MapHorseRacing;
import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.MultiHorseRacing;
import minizorks.primequest.src.zork.zork.Primequest;
import minizorks.whodunit.Parallel.src.zork.Whodunit;

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

    public static void runWhodunit(){
        try {
            Whodunit.runWhodunit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
