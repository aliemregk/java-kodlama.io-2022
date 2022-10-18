package hw3.part2.polymorphismDemo;

public class Main {
    public static void main(String[] args) {

        // BaseLogger[] loggers = new BaseLogger[] { new FileLogger(), new
        // EmailLogger(), new DatabaseLogger(),
        // new ConsoleLogger() };

        // for (BaseLogger logger : loggers) {
        // logger.log("Log.");
        // }

        CustomerManager customerManager1 = new CustomerManager(new DatabaseLogger());
        CustomerManager customerManager2 = new CustomerManager(new FileLogger());
        CustomerManager customerManager3 = new CustomerManager(new EmailLogger());
        CustomerManager customerManager4 = new CustomerManager(new ConsoleLogger());

        customerManager1.add();
        customerManager2.add();
        customerManager3.add();
        customerManager4.add();
    }
}
