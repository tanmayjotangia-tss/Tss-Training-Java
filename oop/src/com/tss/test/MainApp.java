package com.tss.test;

import com.tss.model.Student;

import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter Student Details:");
        Student student = new Student();

        while (true) {
            System.out.print("Student ID: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();
                if (student.setId(id)) break;
                System.out.println("Invalid ID. Must be positive.");
            } else {
                System.out.println("Invalid input. Enter an integer.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Student Name: ");
            String name = scanner.nextLine();
            if (student.setName(name)) break;
            System.out.println("Invalid name. Only characters allowed.");
        }

        while (true) {
            System.out.print("Student Course: ");
            String course = scanner.nextLine();
            if (student.setCourse(course)) break;
            System.out.println("Invalid course. Only characters allowed.");
        }

        while (true) {
            System.out.print("Fees Paid: ");
            if (scanner.hasNextDouble()) {
                double paid = scanner.nextDouble();
                scanner.nextLine();
                if (student.setFeesPaid(paid)) break;
                System.out.println("Invalid amount.");
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Total Fees: ");
            if (scanner.hasNextDouble()) {
                double total = scanner.nextDouble();
                scanner.nextLine();
                if (student.setTotalFees(total)) break;
                System.out.println("Invalid amount.");
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Display Student Profile");
            System.out.println("2. Pay Fees");
            System.out.println("3. View Pending Fees");
            System.out.println("4. Update Course");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    student.displayProfile();
                    break;
                case 2:
                    double pending = student.getPendingFees();
                    if (pending == 0) {
                        System.out.println("No pending fees,no payment required");
                        break;
                    }
                    while (true) {
                        System.out.println("Pending Fees: " + pending);
                        System.out.print("Enter amount to pay: ");
                        if (scanner.hasNextDouble()) {
                            double amount = scanner.nextDouble();
                            if (student.payFees(amount)) break;
                            System.out.println("Invalid payment amount.");
                        } else {
                            System.out.println("Invalid input. Enter a number.");
                            scanner.next();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Pending Fees: " + student.getPendingFees());
                    break;
                case 4:
                    while (true) {
                        System.out.println("Current Course:" + student.getCourse());
                        System.out.print("Enter new course: ");
                        String newCourse = scanner.next();
                        scanner.nextLine();
                        if (student.setCourse(newCourse)) break;
                        System.out.println("Invalid course.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Enter a valid choice (1–5).");
            }
        }
    }
}