package com.tss.day6.service;

import com.tss.day6.model.SingleStudent;

import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter Student Details:");
        SingleStudent singleStudent = new SingleStudent();

        while (true) {
            System.out.print("Student ID: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();
                if (singleStudent.setId(id)) break;
                System.out.println("Invalid ID. Must be positive.");
            } else {
                System.out.println("Invalid input. Enter an integer.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Student Name: ");
            String name = scanner.nextLine();
            if (singleStudent.setName(name)) break;
            System.out.println("Invalid name. Only characters allowed.");
        }

        while (true) {
            System.out.print("Student Course: ");
            String course = scanner.nextLine();
            if (singleStudent.setCourse(course)) break;
            System.out.println("Invalid course. Only characters allowed.");
        }

        while (true) {
            System.out.print("Fees Paid: ");
            if (scanner.hasNextDouble()) {
                double paid = scanner.nextDouble();
                scanner.nextLine();
                if (singleStudent.setFeesPaid(paid)) break;
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
                if (singleStudent.setTotalFees(total)) break;
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
                    singleStudent.displayProfile();
                    break;
                case 2:
                    double pending = singleStudent.getPendingFees();
                    if (pending == 0) {
                        System.out.println("No pending fees,no payment required");
                        break;
                    }
                    while (true) {
                        System.out.println("Pending Fees: " + pending);
                        System.out.print("Enter amount to pay: ");
                        if (scanner.hasNextDouble()) {
                            double amount = scanner.nextDouble();
                            if (singleStudent.payFees(amount)) break;
                            System.out.println("Invalid payment amount.");
                        } else {
                            System.out.println("Invalid input. Enter a number.");
                            scanner.next();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Pending Fees: " + singleStudent.getPendingFees());
                    break;
                case 4:
                    while (true) {
                        System.out.println("Current Course:" + singleStudent.getCourse());
                        System.out.print("Enter new course: ");
                        String newCourse = scanner.next();
                        scanner.nextLine();
                        if (singleStudent.setCourse(newCourse)) break;
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