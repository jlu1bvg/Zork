package minizorks.whodunit.Parallel.src.zork.threads;

import minizorks.whodunit.Parallel.src.zork.utils.TimeController;

public class ChronoHandler extends Thread {
    private final TimeController controller;
    public ChronoHandler(TimeController tc) {
        super(String.format("TimeController [%s]", tc.getHash()));

        controller = tc;
    }

    @Override
    public void run() {
        controller.start();
    }
}
