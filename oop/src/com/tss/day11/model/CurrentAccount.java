package com.tss.day11.model;

public class CurrentAccount extends Account{
    public static final double MIN_BALANCE=500;

    public CurrentAccount(String name, double balance){
        super(name,balance);
    }

    public void deposit(double amount){
            if(amount <0){
                System.out.println("Enter valid amount");
                return;
            }
            setBalance(getBalance()+amount);
//            System.out.println("Amount deposited successfully !!");

    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter valid amount");
            return;
        }
        if (getBalance() - amount >= MIN_BALANCE) {
            setBalance(getBalance() - amount);
//            System.out.println("Withdraw Successful");
        } else {
            System.out.println("Minimum balance must be maintained");
        }
    }

}
