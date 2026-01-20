package com.tss.utils;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            }
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }

    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
