package hw3.part1;

import hw3.part1.business.CarCreditManager;
import hw3.part1.business.CustomerManager;
import hw3.part1.business.MilitaryCreditManager;
import hw3.part1.business.TeacherCreditManager;
import hw3.part1.entities.Customer;

public class Program {
    public static void main(String[] args) {

        // CreditManager creditManager = new CreditManager();

        // creditManager.calculate();
        // creditManager.save();

        // Customer customer = new Customer(1, "Ankara");

        // CustomerManager customerManager = new CustomerManager(customer);
        // customerManager.save();
        // customerManager.delete();

        // Company company = new Company("A Company", "100000");
        // company.setId(100);

        // CustomerManager customerManager2 = new CustomerManager(company);
        // customerManager2.save();
        // customerManager2.delete();

        // Person person = new Person("Ali", "Emre", "12345");
        // person.setId(11);

        // CustomerManager customerManager3 = new CustomerManager(person);
        // customerManager3.save();
        // customerManager3.delete();

        // Customer c1 = new Customer();
        // Customer c2 = new Person();
        // Customer c3 = new Company();

        CustomerManager customerManager1 = new CustomerManager(new Customer(), new MilitaryCreditManager());
        customerManager1.giveCredit();

        CustomerManager customerManager2 = new CustomerManager(new Customer(), new TeacherCreditManager());
        customerManager2.giveCredit();

        CustomerManager customerManager3 = new CustomerManager(new Customer(), new CarCreditManager());
        customerManager3.giveCredit();
    }
}
