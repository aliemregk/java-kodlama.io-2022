package hw3.part2.abstractDemo;

public class CustomerManager {

    BaseDatabaseManager databaseManager;

    public void getAll() {
        databaseManager.getData();
    }
}
