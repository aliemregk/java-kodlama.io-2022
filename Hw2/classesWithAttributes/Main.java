package classesWithAttributes;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Laptop 1");
        product1.setDescription("Asus Laptop");
        product1.setPrice(5000);
        product1.setStockAmount(3);

        Product product2 = new Product(2, "Laptop 2", "MSI Laptop", 3500, 2, "Black");

        ProductManager productManager = new ProductManager();
        productManager.add(product1);
        productManager.add(product2);

        System.out.println(product1.getCode());
        System.out.println(product2.getCode());
    }
}
