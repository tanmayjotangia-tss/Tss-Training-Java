package com.tss.test;

import com.tss.model.SingleStudent;
import java.util.Scanner;

public class MultiStudentApp {

    static Scanner scanner = new Scanner(System.in);
    static int totalStudents;
    static int currentIndex = 0;
    static SingleStudent[] singleStudents;

    public static void main(String[] args) {

        while (true) {
            System.out.print("Enter the number of students you want to register (max 10): ");
            if (scanner.hasNextInt()) {
                totalStudents = scanner.nextInt();
                scanner.nextLine();

                if (totalStudents > 0 && totalStudents <= 10) {
                    break;
                } else {
                    System.out.println("Number of students must be between 1 and 10.");
                }
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }

        singleStudents = new SingleStudent[totalStudents];

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add new Student");
            System.out.println("2. Pay Fees");
            System.out.println("3. View Pending Fee");
            System.out.println("4. Display a Student");
            System.out.println("5. Display all Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:{
                    if (currentIndex < totalStudents) {
                        createNewStudent();
                        currentIndex++;
                    } else {
                        System.out.println("Student limit reached.");
                    }
                    break;
                 }
                case 2:{
                    while(true){
                        if(!checkStudents()){
                            break;
                        }
                        SingleStudent singleStudent = findStudentById();
                        if(singleStudent != null){
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
                                    scanner.nextLine();
                                    if (singleStudent.payFees(amount)) break;
                                    System.out.println("Invalid payment amount.");
                                    break;
                                } else {
                                    System.out.println("Invalid input. Enter a number.");
                                    scanner.next();
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    while(true){
                        if(!checkStudents()){
                            break;
                        }
                        SingleStudent singleStudent = findStudentById();
                        if (singleStudent != null) {
                            System.out.println("Pending Fees: " + singleStudent.getPendingFees());
                            break;
                        }
                    }
                    break;
                }
                case 4:{
                    while(true){
                        if(!checkStudents()){
                            break;
                        }
                        SingleStudent singleStudent = findStudentById();
                        if (singleStudent != null) {
                            singleStudent.displayProfile();
                            break;
                        }
                    }
                    break;
                }

                case 5:{
                    if(!checkStudents()){
                        break;
                    }
                    displayAllStudents();
                    break;
                }

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createNewStudent() {
        SingleStudent singleStudent = new SingleStudent();
        while (true) {
            System.out.print("Student ID: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();

                SingleStudent existing = null;
                for (int i = 0; i < currentIndex; i++) {
                    if (singleStudents[i].getId() == id) {
                        existing = singleStudents[i];
                        break;
                    }
                }
                if (existing != null) {
                    System.out.println("ID already exists. Please enter a different ID.");
                } else if (singleStudent.setId(id)) {
                    break;
                } else {
                    System.out.println("Invalid ID.");
                }
            } else {
                System.out.println("Enter a number.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Student Name: ");
            String name = scanner.nextLine();
            if (singleStudent.setName(name)) break;
            System.out.println("Invalid name.");
        }

        while (true) {
            System.out.print("Student Course: ");
            String course = scanner.nextLine();
            if (singleStudent.setCourse(course)) break;
            System.out.println("Invalid course.");
        }

        while (true) {
            System.out.print("Total Fees: ");
            if (scanner.hasNextDouble()) {
                double total = scanner.nextDouble();
                scanner.nextLine();
                if (singleStudent.setTotalFees(total)) break;
                System.out.println("Invalid amount.");
            } else {
                System.out.println("Enter a number.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Fees Paid: ");
            if (scanner.hasNextDouble()) {
                double paid = scanner.nextDouble();
                scanner.nextLine();
                if (singleStudent.setFeesPaid(paid)) break;
                System.out.println("Invalid amount.");
            } else {
                System.out.println("Enter a number.");
                scanner.next();
            }
        }

        singleStudents[currentIndex] = singleStudent;
        System.out.println("Student added successfully!");
    }

    private static SingleStudent findStudentById() {
        System.out.print("Enter Student ID: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid ID.");
            scanner.next();
            return null;
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (singleStudents[i].getId() == id) {
                return singleStudents[i];
            }
        }
        System.out.println("Student not found.");
        return null;
    }

    private static void displayAllStudents() {
        if (currentIndex == 0) {
            System.out.println("No students available.");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            System.out.println("\nStudent " + (i + 1));
            singleStudents[i].displayProfileTable();
        }
    }

    private static boolean checkStudents(){
        if (currentIndex == 0) {
            System.out.println("No students registered yet.");
            return false;
        }
        return true;
    }
}

