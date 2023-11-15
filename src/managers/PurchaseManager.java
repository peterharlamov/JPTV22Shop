package managers;

import entity.Customer;
import entity.Product;
import tools.KeyboardInput;

import java.util.*;

public class PurchaseManager {

    private final Scanner scanner;
    private List<Customer> customers;
    private List<Product> products;
    private List<String> sortedCustomersByPurchases;
    private int totalTurnover;
    private CustomerManager customerManager;
    private ProductManager productManager;
    public PurchaseManager(Scanner scanner, CustomerManager customerManager, ProductManager productManager) {
        this.scanner = scanner;
        this.customerManager = customerManager;
        this.productManager = productManager;
        this.customers = customerManager.getListCustomers();
        this.products = productManager.getListProducts();
    }

    public void buyProduct() throws Exception {
        System.out.println("=== Customer buy product ===");
        customerManager.printListCustomers(customers);
        System.out.println("Select customer: ");
        int numberCustomer = KeyboardInput.inputNumberFromRange(0, customers.size());
        productManager.printListProducts(products);
        System.out.println("Select product which you want to buy: ");
        int numberProduct = KeyboardInput.inputNumberFromRange(0, products.size());

        Product setProduct = products.get(numberProduct - 1);
        Customer setCustomer = customers.get(numberCustomer - 1);

        int buyCounter = 0;
        setCustomer.setPurchaseCount(buyCounter + 1);
        setProduct.setProductRating(buyCounter + 1);

        if (setCustomer.getBalance() < setProduct.getPrice()) {
            throw new Exception("Customer don't have enough money to buy this product!");
        }
        customers.get(numberCustomer - 1).setBalance(setCustomer.getBalance() - setProduct.getPrice());
        totalTurnover =+ setProduct.getPrice();
        if (setCustomer.getBalance() < 0) {
            setCustomer.setBalance(0);
        }
        System.out.println(
                setCustomer.getFirstName() + setCustomer.getLastName()
                + " bought the " + setProduct.getProductName()
                + " for " + setProduct.getPrice()
        );
    }

    public void getTurnover() {
        if (totalTurnover != 0) {
            System.out.println("Total turnover of the shop is " + totalTurnover);
        } else {
            System.out.println("The shop don't have turnover!");
        }
    }

    public void sortCustomersByNumberOfPurchases() {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPurchaseCount() > 0) {
                List<Customer> sortedList = customers.stream()
                        .sorted(Comparator.comparingInt(Customer::getPurchaseCount).reversed())
                        .toList();
                sortedList.forEach(customer -> System.out.println(customer.getFirstName() +" "+ customer.getLastName() + customer.getPurchaseCount()));
            }
        }
        System.out.println("Sorted Customers: " + customers);
    }
}
