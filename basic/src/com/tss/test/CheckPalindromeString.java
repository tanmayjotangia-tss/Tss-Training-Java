package com.tss.test;

import java.util.Scanner;

public class CheckPalindromeString {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string you want to check");
        String word = scanner.next();
        if(isPalindrome(word)){
            System.out.println("The word " + word + "is a palindrom");
        }else{
            System.out.println("The word " + word + "is not a palindrom");

        }
    }

    private static boolean isPalindrome(String w){
        int length = w.length();
        int left=0,right=length-1;

        while(left<right){
            if(w.charAt(left) != w.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
