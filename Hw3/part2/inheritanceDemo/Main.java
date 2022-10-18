package hw3.part2.inheritanceDemo;

public class Main {
    public static void main(String[] args) {

        CreditUI creditUI = new CreditUI();

        creditUI.calculateCredit(new TeacherCreditManager());
        creditUI.calculateCredit(new FarmerCreditManager());
        creditUI.calculateCredit(new SoldierCreditManager());
    }
}
