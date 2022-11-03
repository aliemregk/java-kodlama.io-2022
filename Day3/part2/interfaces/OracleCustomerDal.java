package hw3.part2.interfaces;

public class OracleCustomerDal implements CustomerDal {

    @Override
    public void add() {
        System.out.println("Added Oracle.");
    }

}
