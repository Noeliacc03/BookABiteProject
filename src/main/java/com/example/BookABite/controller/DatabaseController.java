package com.example.BookABite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DatabaseController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/check-database")
    public String checkDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                System.err.println("Conexión exitosa a la base de datos");
                return "Conexión exitosa a la base de datos.";

            }
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: ");
            return "Error al conectar a la base de datos: " + e.getMessage();
        }
        System.out.println("Conexión fallida.");
        return "Conexión fallida.";
    }
}
