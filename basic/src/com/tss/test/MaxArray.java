package com.tss.test;

import java.util.Scanner;

public class MaxArray {
    public static void main(String[] args) {
//        int[] array = {43,23,75,32,76,34};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int array_size = scanner.nextInt();

        int[] array = new int[array_size];

        for(int i=0;i<array_size;i++){
            System.out.println("Enetr the value of " + (i+1) +" element");
            array[i]=scanner.nextInt();
        }
        int maximum=0;

        for(int i=0; i< array.length;i++){
            if(array[i]>maximum){
                maximum=array[i];
            }
        }
        System.out.println(maximum);
    }
}
