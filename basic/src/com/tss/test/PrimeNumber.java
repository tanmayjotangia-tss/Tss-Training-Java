package com.tss.test;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number to check if prime or not");
        int number = scanner.nextInt();

        boolean isPrime=true;

        for(int i=2;i<Math.sqrt(number);i++){
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime)
            System.out.println("The number is prime");
        else
            System.out.println("The number is not prime");
    }
}
