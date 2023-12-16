package managers;

import java.util.List;
import java.util.Scanner;

import entity.Customer;
import entity.Product;

public class SavingManager {

    public void saveProduct(List<Product> products) {
        DatabaseManager databaseManager = new DatabaseManager();
        for (Product product : products) {
            databaseManager.saveProductToBase(product.getProductName(), product.getPrice());
        }
    }

    public void saveCustomer(List<Customer> customers) {
        DatabaseManager databaseManager = new DatabaseManager();
        for (Customer customer : customers) {
            databaseManager.saveCustomerToBase(customer.getFirstName(), customer.getLastName(), customer.getBalance());
        }
    }
}
