package com.tss.day9.test;

import java.util.Scanner;

public class CheckPalindromeStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string you want to check:");
        StringBuilder word = new StringBuilder(scanner.next());

        String original = word.toString();
        String reversed = word.reverse().toString();

        if(original.equals(reversed)){
            System.out.println("The word is a palindrome");
        } else {
            System.out.println("The word is not a palindrome");
        }
    }
}
