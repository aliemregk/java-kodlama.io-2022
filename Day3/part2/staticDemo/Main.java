package hw3.part2.staticDemo;

public class Main {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        Product product = new Product();
        product.id = 1;
        product.name = "Mouse";
        product.price = 11;

        productManager.add(product);

        // ProductValidator productValidator = new ProductValidator();
        // productValidator.something();

        DatabaseHelper.Connection.createConnection();
        DatabaseHelper.Crud.delete();
    }
}
