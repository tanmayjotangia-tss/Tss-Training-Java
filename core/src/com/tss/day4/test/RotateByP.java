package com.tss.day4.test;

import java.util.Scanner;

public class RotateByP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int array_size = scanner.nextInt();

        int[] array = new int[array_size];

        for(int i=0;i<array_size;i++){
            System.out.println("Enter the value of " + (i+1) +" element");
            array[i]=scanner.nextInt();
        }

        System.out.println("Enter the number of positions to rotate to the right");
        int positions = scanner.nextInt();

        rightRotate(array,array_size,positions);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void rightRotate(int[] arr, int n, int p) {
        p = p % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, p - 1);
        reverse(arr, p, n - 1);
    }
}
