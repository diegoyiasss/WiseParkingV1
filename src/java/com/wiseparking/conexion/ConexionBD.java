package com.wiseparking.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/WiseParking";
    private static final String USER = "root"; // Tu usuario de MySQL (usualmente root)
    private static final String PASSWORD = "Colombia2025*"; // Tu contraseña de MySQL (déjalo vacío si no tiene)

    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a WiseParking.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver MySQL no encontrado - " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
} // Cierra el método conectar()

    public static void main(String[] args) {
        conectar();
    }

} // Cierra la clase ConexionBD (esta debe ser la última línea de código)