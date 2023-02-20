import AbstractFactory.FactoryV3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Please Enter the number of Processors");
        int numberOfProcessors=scanner.nextInt();

        System.out.println("Please Enter the number of Cycles");
        int numberOfCycles=scanner.nextInt();

        System.out.println("Please Enter the file path");
        String filePath=scanner.next();

        Simulator simulator=new BaseSimulator(numberOfProcessors,numberOfCycles,filePath,new FactoryV3());

        simulator.execute();
    }
}