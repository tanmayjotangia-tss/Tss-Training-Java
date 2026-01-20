package com.tss.test;

import java.util.Scanner;

public class Maximum {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number:");
        int a= sc.nextInt();

        System.out.println("Enter second number:");
        int b = sc.nextInt();

        System.out.println("Enter third number");
        int c = sc.nextInt();

//        if(a>b && a>c)
//            System.out.println("First number is the maximum " + a);
//
//        else if (b>a && b>c) {
//            System.out.println("Second number is the maximum " + b);
//        }
//        else {
//            System.out.println("Third number is the maximum " + c);
//        }

        if(a > b){
            if(a>c){
                System.out.println("First number is the maximum " + a);
            }else{
                System.out.println("Third number is the maximum" + c);
            }
        }else if(b>c){
            System.out.println("Second number is maximum" + b);
        }else {
            System.out.println("Third is maximum" + c);
        }

    }
}
