package hw3.part2.interfaces;

public class Main {
    public static void main(String[] args) {

        // CustomerDal customerDal = new MySqlCustomerDal();
        // customerDal.add();

        // customerDal = new OracleCustomerDal();
        // customerDal.add();

        CustomerManager customerManager = new CustomerManager(new OracleCustomerDal());
        customerManager.add();

        customerManager = new CustomerManager(new MySqlCustomerDal());
        customerManager.add();
    }
}
