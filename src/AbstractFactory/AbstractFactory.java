package AbstractFactory;

import BaseSimulatorComponents.BaseClock;
import BaseSimulatorComponents.Processor;
import BaseSimulatorComponents.Scheduler;

import java.util.Queue;

public interface AbstractFactory {
    public BaseClock createClock(int numberOfCycle);
    public Scheduler createScheduler(String filePath) ;

    public Queue<Processor> createProcessor(int numberOfProcessors);
}
