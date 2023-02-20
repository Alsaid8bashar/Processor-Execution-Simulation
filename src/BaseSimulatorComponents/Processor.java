package BaseSimulatorComponents;

public abstract  class Processor implements Comparable<BaseProcessor> {
    protected Task baseTask;
    protected static Report report =new Report();

    public abstract void setTask(Task baseTask) ;
    public abstract void executeTask() ;
    public abstract boolean isAvailable();
    public abstract void setChange() ;
    public abstract void print();
    }
