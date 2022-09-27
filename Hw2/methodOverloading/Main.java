package methodOverloading;

public class Main {
    public static void main(String[] args) {
        FourOps fourOps = new FourOps();
        System.out.println(fourOps.add(2, 3));
        System.out.println(fourOps.add(2, 3, 4));
    }
}
