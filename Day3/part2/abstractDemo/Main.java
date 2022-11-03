package hw3.part2.abstractDemo;

public class Main {
    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager();
        customerManager.databaseManager = new SqlServerDatabaseManager();
        customerManager.getAll();
        customerManager.databaseManager = new OracleDatabaseManager();
        customerManager.getAll();
        customerManager.databaseManager = new MySqlDatabaseManager();
        customerManager.getAll();
    }
}
