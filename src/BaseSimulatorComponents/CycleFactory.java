package BaseSimulatorComponents;

public class CycleFactory {

    public Cycle createCycle(String cycleType,int id ){

        if(cycleType.equals("V1")){
            return new OneSecondCycle(id);
        }

        else throw new IllegalArgumentException();
    }
}
