package com.tss.day11.model;

import com.tss.day11.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract  class Account {
    private static int idCounter=0;
    private int accountId;
    private int accountNumber;
    private double balance;
    private String name;
    private List<Transaction> transactions;

    public Account(String name,double balance){
        this.accountId=++idCounter;
        generateAccountNumber();
        if(balance < 0){
            throw new NegativeAmountException(balance);
        }
        this.balance=balance;
        this.name=name;
        transactions=new ArrayList<Transaction>();

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        if(balance < 0){
            throw new NegativeAmountException(balance);
        }
        this.balance = balance;
    }

    public void generateAccountNumber() {
        Random rand = new Random();
        this.accountNumber = rand.nextInt(1_000_000);
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public void displayAccount(){
        System.out.println("Account ID: " + getId());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder Name: " + getName());
        System.out.println("Current Balance: " + getBalance());
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No Transactions Found");
            return;
        }

        Transaction.printTableHeader();
        for (Transaction t : transactions) {
            t.printTableRow();
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void increaseBalance(double amount) {
        this.balance += amount;
    }

    public void decreaseBalance(double amount) {
        this.balance -= amount;
    }

}
