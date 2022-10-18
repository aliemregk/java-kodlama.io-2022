package hw3.part2.interfaces;

public class CustomerManager {

    private CustomerDal customerDal;

    public CustomerManager(CustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    public void add() {
        this.customerDal.add();
    }
}
