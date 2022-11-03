package hw3.part2.interfaces;

public class MySqlCustomerDal implements CustomerDal{

    @Override
    public void add() {
    System.out.println("Added MySql.");        
    }
    
}
