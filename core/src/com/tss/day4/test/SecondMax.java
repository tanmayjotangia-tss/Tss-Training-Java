package com.tss.day4.test;

import java.util.Scanner;

public class SecondMax {
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

        int maximum=0,second_max=0;

        for(int i=0; i< array.length;i++){
            if(array[i]>maximum){
                second_max=maximum;
                maximum=array[i];
            } else if (array[i]> second_max && array[i] != maximum) {
                second_max=array[i];
            }
        }
        System.out.println(second_max);
    }
}
