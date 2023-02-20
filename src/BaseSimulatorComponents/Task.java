package BaseSimulatorComponents;

public interface Task extends Comparable<Task> {

    public int getCreationTime();

    public int getExeTime();
    public void setState(String state);
}


