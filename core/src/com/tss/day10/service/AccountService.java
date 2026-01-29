package com.tss.day10.service;

import com.tss.day10.model.Account;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class AccountService {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(Account.count);
//        System.out.println("Enter details of account");
//
//        System.out.println("Enter Id:");
//        int id = scanner.nextInt();
//
//        System.out.println("Enter Account Number");
//        int accNumber = scanner.nextInt();
//
//        System.out.println("Enter Account Holder Name");
//        String accHolderName = scanner.next();
//
//        System.out.println("Enter Account type:\n1. Saving\n2. Current");
//        int accType = scanner.nextInt();
//
//        String accountType = "";
//        switch (accType){
//            case 1 : accountType= String.valueOf(AccountType.SAVING);break;
//            case 2 : accountType = String.valueOf(AccountType.CURRENT);break;
//            default:
//                System.out.println("Invalid Input");
//        }
//
//        System.out.println("Enter Account Balance");
//        double accBalance= scanner.nextDouble();
//
////        Account acc1 = new Account(101,10000001,"Tanmay","Saving",23423942);
////        Account acc2 = new Account(102,100000002,"Divyaraj","Current",24122432);
//
//        Account acc3 = new Account(id,accNumber,accHolderName,accountType,accBalance);
//
//        System.out.println(acc3.getAccountType());
//
//        System.out.println(Account.count);
//
//        System.out.println("All account types:");
//        AccountType.displayAccountType();

//        Class accountClass = Account.class;
//        Method methods[] = accountClass.getMethods();
//
//        for(Method method:methods){
//            System.out.println(method.getName());
//
//            Parameter[] parameter=method.getParameters();
//
//            for(Parameter para : parameter){
//                System.out.println(para.getName() + "\t" + para.getParameterizedType());
//            }
//        }

//    }


        Class scannerInfo = Scanner.class;
//        System.out.println(scannerInfo.getMethods());
        Method scannerMethods[] = scannerInfo.getMethods();
        for(Method method : scannerMethods){
            System.out.println(method);}
    }
}
