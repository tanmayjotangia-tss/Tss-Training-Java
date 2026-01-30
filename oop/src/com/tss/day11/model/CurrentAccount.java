package com.tss.day11.model;

import com.tss.day11.exceptions.MinimumBalanceException;
import com.tss.day11.exceptions.NegativeAmountException;

public class CurrentAccount extends Account{
    public static final double MIN_BALANCE=500;

    public CurrentAccount(String name, double balance){
        super(name,balance);
        if(balance < MIN_BALANCE){
            throw new MinimumBalanceException(balance);
        }
    }

    public void deposit(double amount){
            if(amount <0){
                throw new NegativeAmountException(amount);
            }
            setBalance(getBalance()+amount);
//            System.out.println("Amount deposited successfully !!");

    }

//    public void withdraw(double amount) {
//        if (amount <= 0) {
//            throw new NegativeAmountException(amount);
//
//        }
//        if (getBalance() - amount >= MIN_BALANCE) {
//            setBalance(getBalance() - amount);
////            System.out.println("Withdraw Successful");
//        } else {
//            throw new MinimumBalanceException(amount);
//        }
            public void withdraw(double amount) {
                if (amount <= 0) {
                    throw new NegativeAmountException(amount);
                }
                double balanceAfter = getBalance() - amount;
                if (balanceAfter < MIN_BALANCE) {
                    throw new MinimumBalanceException(balanceAfter);
                }
                setBalance(balanceAfter);
            }
    }
