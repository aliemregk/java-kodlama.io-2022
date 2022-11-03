package hw3.part2.staticDemo;

public class ProductManager {

    public void add(Product product) {
        if (ProductValidator.isValid(product)) {
            System.out.println("Product added.");
        } else {
            System.out.println("Validation error.");
        }
    }
}
