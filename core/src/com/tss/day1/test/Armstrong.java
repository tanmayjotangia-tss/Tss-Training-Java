package com.tss.day1.test;

import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number to check if it is an Armstrong number or not");
        int number = scanner.nextInt();

        //Length Calculation
        int length = 0;
        int temp = number;
        while(temp>0){

            temp=temp/10;
            length++;
        }

        int sum=0;
        int temp2 = number;
        while(temp2>0){
            int temp3 = temp2%10;
            sum += (int) Math.pow(temp3,length);
            temp2/=10;
        }

        if(sum == number){
            System.out.println("The number is an Armstrong number");
        }else{
            System.out.println("The number is not an Armstrong number");
        }
    }
}
