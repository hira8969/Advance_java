package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student2";
        String username = "root";
        String password = "Hira2006@";

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from student_data");
            while (rs.next())
            {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + "  " + rs.getString(3));

            }
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
}
