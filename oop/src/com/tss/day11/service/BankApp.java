package com.tss.day11.service;

import com.tss.day11.model.Account;
import com.tss.day11.model.SavingAccount;
import com.tss.day11.model.CurrentAccount;
import com.tss.utils.InputUtil;

public class BankApp {
    static void main(String[] args) {
        Account account =null;

        while(true){
            System.out.println("Welcome to the banking app");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");

            int choice = InputUtil.readInt("Enter your choice:");
            switch (choice){
                case 1 : account = createAccount();
                    System.out.println("Account created successfully !!");
                    break;
                case 2: {
                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    double amount = InputUtil.readDouble("Enter amount to deposit:");
                    account.deposit(amount);
                    break;
                }
                case 3: {
                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    double amount = InputUtil.readDouble("Enter amount to withdraw:");
                    account.withdraw(amount);
                    break;
                }
                case 4: {
                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    System.out.println("Current Balance : " + account.getBalance());
                    break;
                }
                case 5:{
                    if (account == null) {
                        System.out.println("Please create an account first");
                        break;
                    }
                    account.displayAccount();
                    break;
                }
                case 6:{
                    System.out.println("Exiting...");
                    return;
                }
                default:{
                    System.out.println("Enter valid option");
                }
            }
        }
    }

    public static Account createAccount(){
        System.out.println("Types of account ");
        System.out.println("a. Saving Account");
        System.out.println("b. Current Account");

        char accountType = InputUtil.readChar("Enter your account type:");
        switch (accountType){
            case 'a' : return createSavingAccount();

            case 'b' : return createCurrentAccount();

            default:
                System.out.println("Invalid Account Type");
                return null;
        }
    }

    private static SavingAccount createSavingAccount(){
        String name = InputUtil.readString("Enter name:");
        double balance = InputUtil.readDouble("Enter current balance:");
        return new SavingAccount(name, balance);
    }
    private static CurrentAccount createCurrentAccount() {
        String name = InputUtil.readString("Enter name:");
        double balance;
        while (true) {
            balance = InputUtil.readDouble("Enter current balance:");
            if (balance >= CurrentAccount.MIN_BALANCE) {
                break;
            }
            System.out.println("Enter valid balance");
        }
        return new CurrentAccount(name, balance);
    }
}
