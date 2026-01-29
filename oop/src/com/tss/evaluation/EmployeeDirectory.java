package com.tss.evaluation;

import java.util.Scanner;

public class EmployeeDirectory {
    public static Scanner scanner = new Scanner(System.in);
    private static Employee[] employees;
    private static int count;

    static void main() {

    }

    private static void add(Employee e){
        System.out.println("Enter ID:");
        int id = scanner.nextInt();

        System.out.println("Enter Name:");
        String name = scanner.next();

        System.out.println("Enter salary:");
        double salary = scanner.nextDouble();

        employees[count] = new Employee(id,name,salary);
    }

//    private static Employee[] top3HighestPaid(){
//        for()
//    }

}
