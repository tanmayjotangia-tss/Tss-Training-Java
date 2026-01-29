package com.tss.day11.model;

import java.util.Random;

public abstract  class Account {
    private static int id;
    private int accountNumber;
    private double balance;
    private String name;

    public Account(String name,double balance){
        Account.id++;
        generateAccountNumber();
        this.balance=balance;
        this.name=name;

    }

    public String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
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
}
