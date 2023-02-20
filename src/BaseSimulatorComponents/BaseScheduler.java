package BaseSimulatorComponents;

import MaxHeap.ArrayPQv3;

public class BaseScheduler extends Scheduler {
    public BaseScheduler(TaskReader taskReader) {
        this.taskReader =  taskReader;
        this.tasks = new ArrayPQv3<>();
        addTask();
    }

    public boolean isTasksEmpty() {
        return tasks.size()==0;
    }

    public void addTask() {
         taskReader.readTask();
        while (!taskReader.isTaskEmpty()) {
            tasks.insert(taskReader.getTask());
            TaskProcessorPair.addTask(taskReader.getTask());
            taskReader.readTask();
        }
    }

    public void assignTask(Processor p1) {
        p1.setTask(tasks.delMax());
    }

}
