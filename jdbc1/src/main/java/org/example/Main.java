package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student2";
        String username = "root";
        String password = "Hira2006@";

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            // Insert Query
            String query = "INSERT INTO student_data(s_id, s_name, domain) VALUES (?, ?, ?)";

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(query);

            // Set Values


            System.out.println("Connection Closed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Now we are talking to DB");
    }
}