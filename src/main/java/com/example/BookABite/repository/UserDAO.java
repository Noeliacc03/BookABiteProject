package com.example.BookABite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/advancedsoftware";
    private static final String USER = "bookabite_user";
    private static final String PASSWORD = "123";

    public void getAllUsers() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getLong("id"));
                System.out.println("User Name: " + resultSet.getString("name"));
                System.out.println("User Email: " + resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}