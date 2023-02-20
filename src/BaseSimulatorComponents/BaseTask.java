package BaseSimulatorComponents;

public class BaseTask implements Task {
    private static int id = 0;
    private final int creationTime;
    private final int exeTime;
    private final int taskId;
    private final int priority;
    private String state ;

    public BaseTask(int creationTime, int exeTime, int priority) {
        this.creationTime = creationTime;
        this.exeTime = exeTime;
        this.taskId = ++id;
        this.priority = priority;
        state="waiting";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int getCreationTime() {
        return creationTime;
    }

    @Override
    public int getExeTime() {
        return exeTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getTaskId() {
        return taskId;
    }

    @Override
    public int compareTo(Task o) {
        BaseTask bt=(BaseTask) o;
        if (this.priority > bt.priority)
            return 1;
        if (this.priority < bt.priority)
            return -1;
        if (this.priority == bt.priority) {
            if (this.exeTime > bt.exeTime)
                return 1;
            else return -1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Task:" + taskId +" "+state ;
    }
}
