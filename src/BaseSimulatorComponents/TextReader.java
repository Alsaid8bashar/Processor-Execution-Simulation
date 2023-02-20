package BaseSimulatorComponents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class TextReader implements TaskReader {
    private int lineForSkip=0;
    private String filePath;
    BaseTask baseTask = null;
    public TextReader(String filePath) {
        this.filePath = filePath;
    }

    public void readTask() {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int id= BaseClock.getCurrentCycle().getCycleId();
            baseTask = reader.lines()
                    .skip(lineForSkip)
                    .map(line -> {
                        String[] array = line.split(" ");
                        try {
                            int value = Integer.parseInt(array[2]);
                            int creationTime = Integer.parseInt(array[0]);
                            if ((value == 1 || value == 0) && (creationTime == BaseClock.getCurrentCycle().getCycleId())) {
                                lineForSkip++;
                                return new BaseTask(creationTime, Integer.parseInt(array[1]), value);
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing integer value: " + e.getMessage());
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

    }
    public boolean isTaskEmpty(){
        return baseTask ==null;
    }

    public BaseTask getTask() {
        return baseTask;
    }

}
