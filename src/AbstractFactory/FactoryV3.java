package AbstractFactory;

import BaseSimulatorComponents.*;

import java.util.PriorityQueue;
import java.util.Queue;

public class FactoryV3 implements AbstractFactory {

    @Override
    public BaseClock createClock(int numberOfCycle) {
        BaseClock.getClock().setCycles(numberOfCycle,"V1");
        return BaseClock.getClock();
    }
    @Override
    public Scheduler createScheduler(String filePath) {
        return new BaseScheduler(new TextReader(filePath));
    }

    @Override
    public Queue<Processor> createProcessor(int numberOfProcessor) {
        PriorityQueue<Processor>  tempList=new PriorityQueue<>();
        for(int i=0; i<numberOfProcessor;i++)
            tempList.add(new BaseProcessor(i+1));
        return tempList;
    }
}
