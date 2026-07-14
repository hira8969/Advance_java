package org.example;

import java.util.Scanner;

public class Menu
{



    public static void add()
    {

    }
    public static void view()
    {

    }
    public static void update()
    {

    }
    public static void delete()
    {

    }
    public static void operation()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Your choice \n1.Add data \n2.Read data \n3.Update data \n4.Delete data \n5.exit");
        int choice= sc.nextInt();
        switch (choice)
        {
            case 1: add();
            break;
            case 2: view();
            break;
            case 3: update();
            break;
            case 4: delete();
            break;
//            case 5: exit();
//            break;
            default:
                System.out.println("plese enter valid choice between 1 to 4");
        }
    }
}
