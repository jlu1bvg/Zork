package minizorks.whodunit.Parallel.src.zork.utils;

public class Stopper {
    private static boolean stop = false;
    public Stopper() {

    }
    public static void stopThis() {
        stop = true;
    }
    public static boolean getStopped(){
        return stop;
    }
}
