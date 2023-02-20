package BaseSimulatorComponents;

public class BaseProcessor extends Processor {
    private final int processorId;
    private boolean available;
    private long availableTime;
    private String state;
    public BaseProcessor(int processorId) {
        this.processorId = processorId;
        available = true;
    }

    public int getProcessorId() {
        return processorId;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setChange() {
        this.available = !(available);
    }


    @Override
    public void setTask(Task baseTask) {
        this.baseTask = (BaseTask) baseTask;
        availableTime = baseTask.getExeTime() + BaseClock.getCurrentCycle().getCycleId() - 1;
        baseTask.setState("running");
        setChange();
    }

    @Override
    public void executeTask() {
        if (baseTask == null)
            throw new IllegalArgumentException();
        if (availableTime == BaseClock.getCurrentCycle().getCycleId()) {
            baseTask.setState("completed");
            report.addReportV1(BaseClock.getCurrentCycle(), baseTask, this);
            availableTime = 0;
            setChange();
        }
    }

    @Override
    public int compareTo(BaseProcessor o) {
        if (this.availableTime > o.availableTime)
            return 1;
        if (this.availableTime == o.availableTime)
            return 0;
        else
            return -1;
    }
    public void print(){
        this.report.print();
    }
    @Override
    public String toString() {
        return  "Processor:" + processorId+" " ;
    }

}