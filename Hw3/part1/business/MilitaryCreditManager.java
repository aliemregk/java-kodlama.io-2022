package hw3.part1.business;

public class MilitaryCreditManager extends BaseCreditManager implements ICreditManager {

    @Override
    public void calculate() {
        System.out.println("Military credit calculated.");
    }

}
