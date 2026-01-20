package com.tss.test;

import java.util.Scanner;

public class WaterBill {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the units consumed");
        int units = scanner.nextInt();

        int meter_charge=75;
        int charge=0;

        if(units <0){
            System.out.println("Enter valid units");
            return;
        }
        else if(units <= 100){
            charge = units*5;
        }else{
            if(units <= 250){
                charge = units*10;
            }
            else{
                charge = units*20;
            }
        }

        int total_water_bill = charge + meter_charge;
        System.out.println("The totak water bill is " + total_water_bill);
    }
}
