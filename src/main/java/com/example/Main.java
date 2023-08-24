package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String sqlSelectAllPersons = "SELECT * FROM person";
        String connectionUrl = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";

try (Connection connection = DriverManager.getConnection(connectionUrl, "root", "1234567"); 
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectAllPersons); 
        ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            System.out.println(id);
            System.out.println(firstName);
            System.out.println(lastName);
        }
} catch (SQLException e) {
    // handle the exception
    e.printStackTrace();
}
    }
}