package com.tss.day10.model;

public class Account {
    private int id,accountNumber;
    private String name,accountType;
    private double balance;

    public static int count;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setCount(int count) {
        Account.count = count;
    }

    public String getAccountType() {
        return accountType;
    }

    public Account(int id, int accountNumber, String name, String accountType, double balance){
        this.id=id;
        this.accountNumber=accountNumber;
        this.name=name;
        this.accountType=accountType;
        this.balance=balance;
        count++;

    }
}
