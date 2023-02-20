package BaseSimulatorComponents;

import java.util.Queue;

public abstract class Clock {
    protected static Queue<Cycle> cycles;

    public void tick() {
    }

    public static Cycle getCurrentCycle() {
        return null;
    }

    public boolean isCyclesEmpty() {
        return false;
    }
}
