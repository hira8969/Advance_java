package org.example.dao;


import org.example.entity.Student;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class StudentDao {

    Scanner sc = new Scanner(System.in);

    public void addStudent() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Id : ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Domain : ");
            String course = sc.nextLine();

            String query = "insert into student_data(s_id,s_name,domain) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, course);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("Student Added Successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "select * from student_data";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("\n----- STUDENTS -----");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("s_id") + " | " +
                                rs.getString("s_name") + " | " +
                                rs.getString("domain")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudent() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student Id : ");
            int id = sc.nextInt();

            String query = "select * from student_data where s_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                System.out.println(
                        rs.getInt("s_id") + " | " +
                                rs.getString("s_name") + " | " +
                                rs.getString("domain")
                );
            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student Id : ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter New Name : ");
            String name = sc.nextLine();

            System.out.print("Enter New Course : ");
            String course = sc.nextLine();

            String query = "update student_data set s_name=?, domain=? where s_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, id);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("Student Updated");
            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student Id : ");
            int id = sc.nextInt();

            String query = "delete from student_data where s_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("Student Deleted");
            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}