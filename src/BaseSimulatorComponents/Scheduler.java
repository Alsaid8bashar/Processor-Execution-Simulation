package BaseSimulatorComponents;

import MaxHeap.MaxPQ;

public abstract class  Scheduler {

    public  TaskReader taskReader;
    public MaxPQ<Task> tasks;
    public abstract void assignTask(Processor p1) ;
    public abstract boolean isTasksEmpty();
    public abstract void addTask() ;
}
