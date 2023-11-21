package main;

import entity.Customer;
import entity.Product;
import managers.CustomerManager;
import managers.ProductManager;
import managers.PurchaseManager;
import managers.SaveManager;
import tools.KeyboardInput;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner scanner;
    private final SaveManager saveManager;
    private List<Customer> customers;
    private List<Product> products;
    private final ProductManager productManager;
    private final CustomerManager customerManager;
    private final PurchaseManager purchaseManager;

    public App() {
        this.scanner = new Scanner(System.in);
        this.saveManager = new SaveManager();
        this.productManager = new ProductManager(scanner);
        this.customerManager = new CustomerManager(scanner);
        this.purchaseManager = new PurchaseManager(scanner, customerManager, productManager);
        this.customers = saveManager.loadCustomers();
        this.products = saveManager.loadProducts();
    }

    void run() throws Exception {
        boolean flag = true;
        System.out.println("----- Harlamov Sneaker Shop -----");
        do {
            System.out.println("List tasks: ");
            System.out.println("0. Exit from the program");
            System.out.println("1. Add product");
            System.out.println("2. List products to sell");
            System.out.println("3. Add customer");
            System.out.println("4. List added customers");
            System.out.println("5. Customer buy product");
            System.out.println("6. Turnover of the shop");
            System.out.println("7. Add money to customer");
            System.out.println("8. Customer rating by number of purchases");
            System.out.println("9. Product sales rating");
            System.out.println("10. Product editing");
            System.out.println("11. Customer editing");

            System.out.println("Select task number: ");
            int task = KeyboardInput.inputNumberFromRange(0, 11);
            switch (task) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    products.add(productManager.addProduct());
                    saveManager.saveProducts(products);
                    break;
                case 2:
                    productManager.printListProducts(products);
                    break;
                case 3:
                    customers.add(customerManager.addCustomer());
                    saveManager.saveCustomers(customers);
                    break;
                case 4:
                    customerManager.printListCustomers(customers);
                    break;
                case 5:
                    purchaseManager.buyProduct();
                    break;
                case 6:
                    purchaseManager.getTurnover();
                    break;
                case 7:
                    customerManager.addMoneyToCustomer();
                    break;
                case 8:
                    purchaseManager.sortCustomersByNumberOfPurchases();
                    break;
                case 9:
                    productManager.productsSalesRating();
                    break;
                case 10:
                    productManager.editProduct();
                    break;
                case 11:
                    customerManager.editCustomer();
                    break;
                default:
                    System.out.println("Enter the number of task you would like to use!");
            }
        } while (flag);
    }
}