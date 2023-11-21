package managers;

import entity.Customer;
import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveManager {

    private final String CUSTOMER_FILENAME = "customers";
    private final String PRODUCTS_FILENAME = "products";

    public void saveCustomers(List<Customer> customers) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(CUSTOMER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
    }

    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(CUSTOMER_FILENAME);
            ois = new ObjectInputStream(fis);
            customers = (List<Customer>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return customers;
    }

    public void saveProducts(List<Product> products) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(PRODUCTS_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
    }

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(PRODUCTS_FILENAME);
            ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return products;
    }
}
