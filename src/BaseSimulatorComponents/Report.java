package BaseSimulatorComponents;

import java.util.LinkedHashMap;
import java.util.Map;

public class Report {
    private Map<Cycle, LinkedHashMap<Processor, Task>> map = new LinkedHashMap<>();
    private  Map<Cycle, TaskProcessorPair> mergedMap = new LinkedHashMap<>();

    public void addReportV1(Cycle cycleV1, Task task, Processor processor) {
        if (map.containsKey(cycleV1))
            map.get(cycleV1).put(processor, task);
        else {
            LinkedHashMap<Processor, Task> t = new LinkedHashMap<>();
            t.put(processor, task);
            map.put(cycleV1, t);
        }
    }
    public  void addReportV2(Cycle cycleV1, TaskProcessorPair taskProcessorPair) {
            mergedMap.put(cycleV1, taskProcessorPair);
    }

    public void print() {
        map.entrySet().stream().forEach(e -> System.out.println(e + "\n" +
                "\n " +
                "==========================="));
        System.out.println();
    }

    public  void printV2(){
        mergedMap.entrySet().stream().forEach(entry -> {
            Cycle cycle = entry.getKey();
            mergedMap.remove(cycle);
            TaskProcessorPair pair = entry.getValue();
            System.out.println("====================================");
            System.out.println(cycle) ;
            pair.print();
        });
    }
}
