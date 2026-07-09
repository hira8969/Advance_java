package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/jdbc1";
            String username="root";
            String pass= "Hira2006@";
            Connection con=DriverManager.getConnection(url,username,pass);
            System.out.println(con);
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}