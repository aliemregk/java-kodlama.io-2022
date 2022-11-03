package hw3.part2.staticDemo;

public class ProductValidator {

    static {
        System.out.println("static block");
    }

    public ProductValidator() {
        System.out.println("ctor");
    }

    public static boolean isValid(Product product) {
        if (product.price > 0 && !product.name.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void something() {
        System.out.println("something");
    }
}
