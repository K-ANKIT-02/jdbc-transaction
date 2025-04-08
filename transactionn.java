import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//import java.sql.SQLException;


public class transactionn {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "Drcc@123"; // Change it

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect
            Connection conn = DriverManager.getConnection(url, user, password);

            // Step 3: Disable Auto Commit
            conn.setAutoCommit(false);

            // Step 4: Create Statement
            Statement stmt = conn.createStatement();

            // Transaction - Transfer 2000 from Ram to Shyam
            stmt.executeUpdate("UPDATE accounts SET balance = balance - 2000 WHERE id = 1");
            stmt.executeUpdate("UPDATE accounts SET balance = balance + 2000 WHERE id = 2");

            // Step 5: Commit Transaction
            conn.commit();

            System.out.println("Transaction Successful");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}