import AbstractFactory.AbstractFactory;
import BaseSimulatorComponents.*;

import java.io.IOException;
import java.util.Queue;

public class BaseSimulator implements Simulator {
    private Scheduler scheduler;
    private Queue<Processor> processors;
    private BaseClock clock;
    private TaskProcessorPair taskProcessorPair = new TaskProcessorPair();
    private Report report = new Report();

    public BaseSimulator(int numberOfProcessors, int numberOfCycle, String filePath, AbstractFactory factory) throws IOException {
        processors = factory.createProcessor(numberOfProcessors);
        clock = factory.createClock(numberOfCycle);
        scheduler = factory.createScheduler(filePath);
        taskProcessorPair.addProcessor(processors);
    }

    @Override
    public void execute() {
        if (clock.isCyclesEmpty()) {
            return;
        }
        addNewlyCreatedTasks();
        assignTasksToProcessors();
        processorExecute();
        report.addReportV2(BaseClock.getCurrentCycle(), taskProcessorPair);
        print();
        clock.tick();
        execute();
    }

    private void addNewlyCreatedTasks() {
        scheduler.addTask();
    }

    private void assignTasksToProcessors() {
        while (!(scheduler.isTasksEmpty())) {
            if (processors.peek().isAvailable()) {
                scheduler.assignTask(processors.peek());
                processors.add(processors.poll());
            } else
                break;
        }
    }

    private void processorExecute() {
        for (Processor p : processors) {
            if (!(p.isAvailable())) {
                p.executeTask();
            }
        }
    }

    private void print() {
        report.printV2();
    }
}
