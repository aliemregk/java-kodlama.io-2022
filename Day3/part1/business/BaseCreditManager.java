package hw3.part1.business;

public abstract class BaseCreditManager {

    public abstract void calculate();

    public void save() {
        System.out.println("Credit saved");
    }

}
