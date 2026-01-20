package com.tss.test;

import java.util.Scanner;

public class ProductArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int array_size = scanner.nextInt();

        int[] array = new int[array_size];

        for(int i=0;i<array_size;i++){
            System.out.println("Enter the value of " + (i+1) +" element");
            array[i]=scanner.nextInt();
        }

        int[] product_Array = productArray(array);

        for (int prod_value : product_Array) {
            System.out.println(prod_value + " ");
        }
    }

    private static int[] productArray(int[] array){
        int n = array.length;
        int[] prod = new int[n];

        prod[0]=1;
        for (int i = 1; i < n; i++) {
            prod[i] = prod[i-1]*array[i-1];
        }

        int rightprod=1;
        for(int i=n-1;i>=0;i--){
            prod[i] = prod[i]*rightprod;
            rightprod*=array[i];
        }
        return prod;
    }
}
