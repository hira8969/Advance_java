package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

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
            System.out.println("Enter Student Id:\nName:\nDomain: ");
            Scanner sc= new Scanner(System.in);
            int id= sc.nextInt();
            sc.nextLine();
            String name= sc.nextLine();
            String domain= sc.nextLine();
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3,domain );

            // Execute Query
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data Inserted Successfully!");
            } else {
                System.out.println("Data Insertion Failed!");
            }

            // Close Resources
            ps.close();
            con.close();

            System.out.println("Connection Closed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}