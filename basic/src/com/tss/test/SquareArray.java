package com.tss.test;

import java.util.Scanner;

public class SquareArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int array_size = scanner.nextInt();

        int[] array = new int[array_size];

        for(int i=0;i<array_size;i++){
            System.out.println("Enter the value of " + (i+1) +" element");
            array[i]=scanner.nextInt();
        }

        int[] sorted_array = squareSorted(array);

//        for (int i = 0; i < array_size; i++) {
//            System.out.print(sorted_array[i] + " ");
//        }

        for(int val : sorted_array){
            System.out.println(val + " ");
        }

    }

    private static int[] squareSorted(int[] array){
        int n=array.length;
        int[] result = new int[n];
        int left=0,right=n-1,index=n-1;

        while(left<=right){
            int leftSquare = array[left]*array[left];
            int rightSquare = array[right]*array[right];

            if(leftSquare > rightSquare){
                result[index] = leftSquare;
                left++;
            }else{
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }
}
