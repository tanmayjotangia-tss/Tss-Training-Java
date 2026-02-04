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
        double balanceBefore=getBalance();
        double interest = 0;
        double finalAmount=amount;
        if (amount > 50000) {
            interest = amount * OFFER_RATE / 100;
            finalAmount+=interest;
            System.out.println("Offer Interest Added: " + interest);
        }
        increaseBalance(finalAmount);

        Transaction transaction = new Transaction("Deposit",0,getAccountNumber(),amount,balanceBefore,getBalance());
        addTransaction(transaction);
//        System.out.println("Deposit successful.");
    }


    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException(amount);
        }
        double balanceBefore=getBalance();
        if (amount <= getBalance()) {
            decreaseBalance(amount);
            Transaction transaction = new Transaction("Withdraw",getAccountNumber(),0,amount,balanceBefore,getBalance());
            addTransaction(transaction);
//            System.out.println("Withdraw Successful");
        } else {
            throw new MinimumBalanceException(amount);
        }
    }

}
