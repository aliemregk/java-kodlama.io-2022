package hw3.part1.business;

public class TeacherCreditManager extends BaseCreditManager implements ICreditManager {

    @Override
    public void calculate() {
        System.out.println("Teacher credit calculated.");
    }

}
