package managers;

import entity.Customer;
import tools.KeyboardInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {

    private final Scanner scanner;
    private List<Customer> customers;

    public CustomerManager(Scanner scanner) {
        this.scanner = scanner;
        this.customers = new ArrayList<>();
    }

    public Customer addCustomer() {
        System.out.println("=== Adding new customer ===");
        Customer customer = new Customer();
        System.out.println("Enter Firstname: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Enter Lastname: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("Enter current balance: ");
        customer.setBalance(scanner.nextInt());
        System.out.println("Added customer: " + customer.toString());
        return customer;
    }

    public List<Customer> getListCustomers() {
        return customers;
    }

    public int printListCustomers(List<Customer> customers) {
        int count = 0;
        System.out.println("List customers: ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.printf(
                    "%d. %s, %s, %d%n",
                    i + 1,
                    customers.get(i).getFirstName(),
                    customers.get(i).getLastName(),
                    customers.get(i).getBalance()
            );
            count++;
        }
        return count;
    }

    public void addMoneyToCustomer() {
        System.out.println("=== Adding Money To Customer ===");
        if (customers.isEmpty()) {
            System.out.println("Before editing at first add the customer!");
        }
        printListCustomers(customers);
        System.out.println("Select the customer: ");
        int setCustomer = KeyboardInput.inputNumberFromRange(0, customers.size());
        int currentBalanceOfCustomer = customers.get(setCustomer - 1).getBalance();
        System.out.println("Current balance of customer is " + currentBalanceOfCustomer);
        System.out.println("Add money to customer: ");
        int setAmount = scanner.nextInt();
        int newBalance = currentBalanceOfCustomer + setAmount;
        customers.get(setCustomer - 1).setBalance(newBalance);
        System.out.println("The new balance of customer is " + customers.get(setCustomer - 1).getBalance());
    }

    public void editCustomer() {
        System.out.println("=== Editing Customer ===");
        if (customers.isEmpty()) {
            System.out.println("Before editing at first add the customer!");
        }
        printListCustomers(customers);
        System.out.println("Select customer which you want to edit: ");
        int setCustomer = KeyboardInput.inputNumberFromRange(0, customers.size());
        System.out.println("Enter new firstname of customer: ");
        String updatedFirstName = scanner.nextLine();
        System.out.println("Enter new lastname of customer: ");
        String updatedLastname = scanner.nextLine();
        customers.get(setCustomer - 1).setFirstName(updatedFirstName);
        customers.get(setCustomer - 1).setLastName(updatedLastname);
        System.out.println("The updated product " + customers.get(setCustomer - 1).toString());
    }
}
