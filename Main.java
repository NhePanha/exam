package Exam;

import java.sql.*;
public class Main {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "com.jdbc:mysql://localhost:3306/Data_base";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) {
        // Connection, statement, and result set objects
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Connect to the MySQL database
            conn = DriverManager.getConnection("com.jdbc:mysql://localhost:3306/Data_base","root","");

            // Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT `Id`, `name`, `price_per_unit`, `active_for_sell` FROM `tb_product`";
            rs = stmt.executeQuery(sql);

            // Iterate through the result set and print each product
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price_per_unit");
                boolean active = rs.getBoolean("active_for_sell");

                System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price + ", Active: " + active);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection, statement, and result set
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
