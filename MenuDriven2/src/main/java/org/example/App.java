package org.example;

import org.example.dao.StudentDao;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDao dao = new StudentDao();

        int choice;

        do {

            System.out.println("\n-----------Menu Driven-----------");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Id");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    dao.registerStudent();
                    break;

                case 2:
                    dao.viewStudent();
                    break;

                case 3:
                    dao.searchStudent();
                    break;

                case 4:
                    dao.updateStudent();
                    break;

                case 5:
                    dao.deleteStudent();
                    break;

                case 0:
                    System.out.println("Thank You...");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        } while (choice != 0);

    }
}