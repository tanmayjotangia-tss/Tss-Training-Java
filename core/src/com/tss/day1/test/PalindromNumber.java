package com.tss.day1.test;

import java.util.Scanner;

public class PalindromNumber {
    public static void main(String[] main){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number to check if the number is Palindrome of not");

        int number = scanner.nextInt();

        int temp=number;
        int answer=0;
        while(temp>0){
            int temp2=temp%10;
            answer= answer*10 + temp2;
            temp/=10;
        }
        if(answer == number){
            System.out.println("The number is Palindrome");
        }else{
            System.out.println("The number is not Palindrome");
        }

    }
}
