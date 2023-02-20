package BaseSimulatorComponents;

import java.util.LinkedList;

public class BaseClock extends Clock {

    private static final BaseClock baseClock = new BaseClock();

    private BaseClock() {
    }

    public void setCycles(int numberOfCycle, String cycleType) {
        CycleFactory factory = new CycleFactory();
        cycles = new LinkedList<>();
        if (numberOfCycle <= 0)
            throw new IllegalArgumentException();
        for (int i = 1; i <= numberOfCycle; i++) {
            cycles.add(factory.createCycle(cycleType, i));
        }
    }

    public static Cycle getCurrentCycle() {
        return cycles.peek();
    }

    public static BaseClock getClock() {
        return baseClock;
    }

    public boolean isCyclesEmpty() {
        return cycles.size() == 0;
    }

    public void tick() {
        try {
            Thread.sleep(cycles.poll().getPeriod());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
