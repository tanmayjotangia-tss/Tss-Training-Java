package com.tss.day2.test;

import java.util.Scanner;

public class RideBillCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int total_bill=0;
        System.out.println("Enter the height in cm");
        int height = scanner.nextInt();

        if (height<0){
            System.out.println("Enter valid height");
        }
        else if(height>120){
            System.out.println("Enter the age of the rider");
            int age = scanner.nextInt();

            if(age<12){
                total_bill+=5;
            } else if (age>=12 && age<=18) {
                total_bill+=7;
            } else if (age>=45 && age<=55 ) {
                total_bill+=0;
            }
            else {total_bill+=12;}

            System.out.println("Want photos?");
            boolean photos = scanner.hasNextBoolean();

            if(photos) {
                total_bill += 3;
            }
        }
        else {
            System.out.println("Must be above 120 cm height");
        }
        System.out.println("Total bill is " + total_bill);
    }
}
