package com.tss.test;

import java.util.Scanner;

public class CurrencyDenominator {
    public static void main(String[] args){
        int limit=50000;
//        int[] currency = {2000,500,200,100};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the currency");
        int amount = scanner.nextInt();

//        for(int i=0;i< currency.length;i++){
//            if()
//        }
        int twoKNotes=0,fiveHunderedNotes=0,twoHundredNotes=0,hunderedNotes=0;
         while(amount/2000>0){
             twoKNotes++;
             amount-=2000;
         }
         while(amount/500>0){
             fiveHunderedNotes++;
             amount-=500;
         }
         while(amount/200>0){
             twoHundredNotes++;
             amount-=200;
         }
         while(amount/100>0){
             hunderedNotes++;
             amount-=100;
         }

         System.out.println("The total currency denominations are :" + twoKNotes + "Two Thousand Notes, " + fiveHunderedNotes + "five hundred notes, " + twoHundredNotes + "two hundred notes, " + hunderedNotes + "hundred notes");
    }
}
