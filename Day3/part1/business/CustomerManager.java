package hw3.part1.business;

import hw3.part1.entities.Customer;

public class CustomerManager {

    private Customer customer;
    private ICreditManager creditManager;

    public CustomerManager(Customer customer, ICreditManager creditManager) {
        this.customer = customer;
        this.creditManager = creditManager;
    }

    public void save() {
        System.out.println("Customer " + this.customer.getId() + " saved.");
    }

    public void delete() {
        System.out.println("Customer " + this.customer.getId() + " deleted.");
    }

    public void giveCredit() {
        this.creditManager.calculate();
        System.out.println("Credit confirmed.");
    }
}
