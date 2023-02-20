package BaseSimulatorComponents;

import BaseSimulatorComponents.Processor;
import BaseSimulatorComponents.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskProcessorPair {

    private static List<Processor>  processors;
    private static List<Task> tasks;

    public TaskProcessorPair() {
        processors = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public  void addProcessor(Queue processor) {

        processors.addAll(processor);
    }

    public static void addTask(Task task) {
        tasks.add(task);
    }
    public void print(){
        for (Processor p : processors){
            if(p.isAvailable())
                System.out.print(p +" Idle ||");
            else {
                System.out.print(p +"Busy ||");
            }
        }
        System.out.println();
        for (Task t : tasks){
                System.out.print(t+" ||");
        }
        System.out.println();

    }
}
