package org.example.dao;

import org.example.entity.Student;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class StudentDao {

    Scanner sc = new Scanner(System.in);

    private static int idCounter = 0;

    static {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT MAX(id) FROM student");

            if (rs.next()) {
                idCounter = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Register Student
    public void registerStudent() {

        try {

            Connection con = DBConnection.getConnection();

            idCounter++;

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Course : ");
            String course = sc.nextLine();

            Student student = new Student(idCounter, name, course);

            String sql = "insert into student values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getCourse());

            idCounter = ps.executeUpdate();

            if (idCounter > 0) {
                System.out.println("\nStudent Registered Successfully.");
                System.out.println(" ID : " + student.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // View All Students
    public void viewStudent() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from student";

            Statement st= con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println("--------------------------");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Course : " + rs.getString("course"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Search
    public void searchStudent() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter ID : ");
            int id = sc.nextInt();

            String sql = "select * from student where id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("ID : " + rs.getInt(1));
                System.out.println("Name : " + rs.getString(2));
                System.out.println("Course : " + rs.getString(3));

            } else {

                System.out.println("Student Not Found");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Update
    public void updateStudent() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name : ");
            String name = sc.nextLine();

            System.out.print("Enter New Course : ");
            String course = sc.nextLine();

            String sql = "update student set name=?,course=? where id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, id);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Updated Successfully");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Delete
    public void deleteStudent() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter ID : ");
            int id = sc.nextInt();

            String sql = "delete from student where id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Deleted Successfully");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}