package com.tss.day1.test;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number to check if the number is perfect number or not");
        int number = scanner.nextInt();

        int sum=0;

        for(int i=1;i<=number/2;i++){
            if(number%i == 0){
                sum+=i;
            }
        }
        if(sum == number){
            System.out.println("The number is a Perfect Number");
        }else{
            System.out.println("The number is not a Perfect Number");
        }
    }
}
