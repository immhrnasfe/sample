package com.mehrana.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {

    // Constants for database connection
    private static final String JDBC_URL = "jdbc:h2:~/test"; // Change as needed
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final int INITIAL_POOL_SIZE = 5;

    // List to manage the connection pool
    private static final List<Connection> connections = new ArrayList<>();

    static {
        try {
            // Load H2 driver (optional for modern JDBC versions, but included for clarity)
            Class.forName("org.h2.Driver");

            // Initialize the connection pool
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                connections.add(createNewConnection());
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Failed to initialize connection pool", e);
        }
    }

    /**
     * Creates a new database connection.
     */
    private static Connection createNewConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    /**
     * Gets a connection from the pool.
     */
    public static synchronized Connection getConnection() {
        if (connections.isEmpty()) {
            try {
                // Create a new connection if the pool is empty
                return createNewConnection();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to create a new connection", e);
            }
        }
        // Remove the first connection from the list and return it
        return connections.remove(0);
    }

    /**
     * Releases a connection back to the pool.
     */
    public static synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            connections.add(connection); // Add the connection back to the list
        }
    }

    /**
     * Closes all connections in the pool.
     */
    public static void closeAllConnections() {
        while (!connections.isEmpty()) {
            try {
                // Remove and close each connection in the list
                connections.remove(0).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
