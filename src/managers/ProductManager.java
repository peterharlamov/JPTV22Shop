package managers;

import entity.Customer;
import entity.Product;
import tools.KeyboardInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private final Scanner scanner;
    private List<Product> products;

    public ProductManager(Scanner scanner) {
        this.scanner = scanner;
        this.products = new ArrayList<>();
    }

    public Product addProduct() {
        System.out.println("=== Adding new product ===");
        Product product = new Product();
        System.out.println("Enter the name of product: ");
        product.setProductName(scanner.nextLine());
        System.out.println("Enter the price of product: ");
        product.setPrice(scanner.nextInt());
        System.out.println("Added product: " + product.toString());
        return product;
    }

    public List<Product> getListProducts() {
        return products;
    }

    public int printListProducts(List<Product> products) {
        int count = 0;
        System.out.println("List customers: ");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf(
                    "%d. %s, %d%n",
                    i + 1,
                    products.get(i).getProductName(),
                    products.get(i).getPrice()
            );
            count++;
        }
        return count;
    }

    public void editProduct() {
        System.out.println("=== Editing Product ===");
        if (products.isEmpty()) {
            System.out.println("Before editing at first add the product!");
        }
        printListProducts(products);
        System.out.println("Select product which you want to edit: ");
        int setProduct = KeyboardInput.inputNumberFromRange(0, products.size());
        System.out.println("Enter new name of product: ");
        String updatedProductName = scanner.nextLine();
        System.out.println("Enter new price of product: ");
        int updatedPrice = scanner.nextInt();
        products.get(setProduct - 1).setProductName(updatedProductName);
        products.get(setProduct - 1).setPrice(updatedPrice);
        System.out.println("The updated product " + products.get(setProduct - 1).toString());
    }

    public void productsSalesRating() {
        List<Product> sortedList = products.stream()
                .sorted(Comparator.comparingInt(Product::getProductRating).reversed())
                .toList();
        sortedList.forEach(product -> System.out.println(product.getProductName()+ " " + product.getPrice()+ " EUR: " + product.getProductRating()));
    }
}
