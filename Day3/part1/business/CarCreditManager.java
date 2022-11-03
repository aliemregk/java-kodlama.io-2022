package hw3.part1.business;

public class CarCreditManager extends BaseCreditManager implements ICreditManager {

    @Override
    public void calculate() {
        System.out.println("Car credit calculated.");
    }

}