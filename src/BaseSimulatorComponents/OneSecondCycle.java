package BaseSimulatorComponents;

public class OneSecondCycle implements Cycle {
    private int cycleId;
    private long period;

    public OneSecondCycle(int cycleId ) {
        this.cycleId = cycleId;
        period=1000;
    }

    @Override
    public String toString() {
        return "Cycle: " + cycleId + '\n';
    }

    @Override
    public int getCycleId() {
        return cycleId;
    }
    @Override
    public long getPeriod() {
        return period;
    }
}


// sh.assignTask(p ,t){



