package com.tss.day11.model;


import com.tss.day11.exceptions.MinimumBalanceException;
import com.tss.day11.exceptions.NegativeAmountException;

public class SavingAccount extends Account{
//    private double offerRate;
    private final double OFFER_RATE=0.5;

    public SavingAccount(String name,double balance){
        super(name,balance);
//        this.offerRate=offerRate;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException(amount);
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
            throw new NegativeAmountException(amount);
        }
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
//            System.out.println("Withdraw Successful");
        } else {
            throw new MinimumBalanceException(amount);
        }
    }

}
