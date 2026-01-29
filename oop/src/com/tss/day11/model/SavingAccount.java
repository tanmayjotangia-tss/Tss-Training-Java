package com.tss.day11.model;


public class SavingAccount extends Account{
//    private double offerRate;
    private final double OFFER_RATE=0.5;

    public SavingAccount(String name,double balance){
        super(name,balance);
//        this.offerRate=offerRate;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter valid amount");
            return;
        }
        double interest = 0;
        if (amount > 50000) {
            interest = amount * OFFER_RATE / 100;
            System.out.println("Offer Interest Added: " + interest);
        }
        setBalance(getBalance() + amount + interest);
//        System.out.println("Deposit successful.");
    }


    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter valid amount");
            return;
        }
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
//            System.out.println("Withdraw Successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

}
