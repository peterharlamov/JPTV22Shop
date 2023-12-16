package managers;

import entity.Customer;
import entity.Product;
import managers.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/jptv22shop?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void saveCustomerToBase(String firstName, String lastName, int balance) {
        String insertQuery = "INSERT INTO customers (first_name, last_name, balance) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, balance);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Данные успешно добавлены в базу данных.");
            } else {
                System.out.println("Не удалось добавить данные в базу данных.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getListCustomersFromBase() {
        String query = "SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int balance = resultSet.getInt("balance");
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setBalance(balance);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void saveProductToBase(String productName, int price) {
        String insertQuery = "INSERT INTO products (product_name, price) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, price);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Данные успешно добавлены в базу данных.");
            } else {
                System.out.println("Не удалось добавить данные в базу данных.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getListProductsFromBase() {
        String query = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                product.setProductName(productName);
                product.setPrice(price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
