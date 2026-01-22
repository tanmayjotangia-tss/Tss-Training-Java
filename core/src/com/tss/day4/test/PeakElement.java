package com.tss.day4.test;

import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int array_size = scanner.nextInt();

        int[] array = new int[array_size];

        for(int i=0;i<array_size;i++){
            System.out.println("Enter the value of " + (i+1) +" element");
            array[i]=scanner.nextInt();
        }
        int peak=peakElementFinder(array);
        System.out.println(peak);

    }

    private static int peakElementFinder(int[] array){
        int peak=0,max_peak=0;

        for(int i=1;i< array.length-1;i++){
            if(array[i-1]<=array[i] && array[i]>=array[i+1]){
                peak=array[i];
                 if(peak>max_peak){
                     max_peak=peak;
                 }
            }
        }
        return max_peak;
    }
}
