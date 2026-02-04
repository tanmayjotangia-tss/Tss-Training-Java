package com.tss.day11.service;

import java.util.ArrayList;
import java.util.List;

import com.tss.day11.exceptions.MinimumBalanceException;
import com.tss.day11.exceptions.NegativeAmountException;
import com.tss.day11.model.Account;
import com.tss.day11.model.CurrentAccount;
import com.tss.day11.model.SavingAccount;
import com.tss.day11.model.Transaction;
import com.tss.utils.InputUtil;

public class BankAppUsingCollection {

    private static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nWelcome to the banking app");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Transfer amount");
            System.out.println("8. Delete Account");
            System.out.println("9. Show Transaction");
            System.out.println("10. Exit");

            int choice = InputUtil.readInt("Enter your choice:");

            switch (choice) {
                case 1:
                    do {
                        Account newAccount = createAccount();
                        if (newAccount != null) {
                            accounts.add(newAccount);
                            System.out.println("Account created successfully!");
                        }
                    } while (InputUtil.createNext());
                    break;

                case 2:
                    Account depAccount = selectAccount();
                    if (depAccount == null) break;

                    while (true) {
                        try {
                            double amount = InputUtil.readDouble("Enter amount to deposit:");
                            depAccount.deposit(amount);
                            System.out.println("Deposit successful!");
                            break;
                        } catch (NegativeAmountException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 3:
                    Account withAccount = selectAccount();
                    if (withAccount == null) break;

                    while (true) {
                        try {
                            System.out.println("Current Balance: " + withAccount.getBalance());
                            double amount = InputUtil.readDouble("Enter amount to withdraw:");
                            withAccount.withdraw(amount);
                            System.out.println("Withdrawal successful!");
                            break;
                        } catch (NegativeAmountException | MinimumBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 4:
                    Account balAccount = selectAccount();
                    if (balAccount != null)
                        System.out.println("Current Balance: " + balAccount.getBalance());
                    break;

                case 5:
                    Account detailsAccount = selectAccount();
                    if (detailsAccount != null)
                        detailsAccount.displayAccount();
                    break;

                case 6:
                    displayAll();
                    break;

                case 7:
                    if (accounts.size() < 2) {
                        System.out.println("Create minimum two accounts first");
                    } else {
                        transferAmount();
                    }
                    break;

                case 8:
                    deleteAccount();
                    break;

                case 9:
                    showTransaction();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Enter valid option");
            }
        }
    }

    private static Account createAccount() {
        System.out.println("Types of account:");
        System.out.println("a. Saving Account");
        System.out.println("b. Current Account");

        char accountType = InputUtil.readChar("Enter your account type:");

        switch (accountType) {
            case 'a':
                return createSavingAccount();
            case 'b':
                return createCurrentAccount();
            default:
                System.out.println("Invalid account type!");
                return null;
        }
    }

    private static SavingAccount createSavingAccount() {
        String name = InputUtil.readValidName("Enter Account Holder Name:");

        while (true) {
            try {
                double balance = InputUtil.readDouble("Enter current balance:");
                return new SavingAccount(name, balance);
            } catch (NegativeAmountException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static CurrentAccount createCurrentAccount() {
        String name = InputUtil.readValidName("Enter Account Holder Name:");

        while (true) {
            try {
                double balance = InputUtil.readDouble("Enter current balance:");
                return new CurrentAccount(name, balance);
            } catch (NegativeAmountException | MinimumBalanceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Account selectAccount() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.println("Available Accounts:");
        for (Account acc : accounts) {
            System.out.println("Account Number: " + acc.getAccountNumber());
        }

        int accNumber = InputUtil.readInt("Enter the account number:");

        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                return acc;
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    private static void transferAmount() {
        System.out.println("Select Sender Account:");
        Account sender = selectAccount();
        if (sender == null) return;
        double senderBalanceBefore= sender.getBalance();


        Account receiver;
        double recieverBalanceBefore;
        while (true) {
            System.out.println("Select Receiver Account:");
            receiver = selectAccount();
            recieverBalanceBefore=receiver.getBalance();
            if (receiver == null) return;

            if (sender != receiver) break;
            System.out.println("Self transfer not allowed!");

        }

        while (true) {
            try {
                System.out.println("Sender Balance: " + senderBalanceBefore);
                double amount = InputUtil.readDouble("Enter amount to transfer:");
                if (amount <= 0) {
                    throw new NegativeAmountException(amount);
                }

                if (sender instanceof SavingAccount) {
                    if (amount > sender.getBalance()) {
                        throw new MinimumBalanceException(sender.getBalance() - amount);
                    }
                }

                if (sender instanceof CurrentAccount) {
                    if (sender.getBalance() - amount < CurrentAccount.MIN_BALANCE) {
                        throw new MinimumBalanceException(sender.getBalance() - amount);
                    }
                }

//                sender.decreaseBalance(amount);
//                receiver.increaseBalance(amount);

//                Transaction senderTransaction = new Transaction("Transfer", sender.getAccountNumber(), receiver.getAccountNumber(),amount,senderBalanceBefore,sender.getBalance());
//                sender.addTransaction(senderTransaction);
//
//                Transaction recieverTransaction =new Transaction("Transfer", sender.getAccountNumber(), receiver.getAccountNumber(),amount,recieverBalanceBefore,receiver.getBalance());
//                receiver.addTransaction(recieverTransaction);

                sender.withdraw(amount);
                receiver.deposit(amount);

                System.out.println("Transfer successful!");
                break;

            } catch (NegativeAmountException | MinimumBalanceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void deleteAccount(){
        if(accounts.isEmpty()){
            System.out.println("No Account available");
            return;
        }

        System.out.println("Select account to be deleted: ");
        Account delAccount = selectAccount();

        if(delAccount == null){
            System.out.println("No such account found");
            return;
        }

        accounts.remove(delAccount);
        System.out.println("Account deleted successfully");
    }
    private static void displayAll() {
        if(accounts.isEmpty()){
            System.out.println("No Accounts available");
            return;
        }

        System.out.println("All Accounts :");
        for(Account acc : accounts){
            acc.displayAccount();
            System.out.println("----------------------------------------------------");
        }
    }

    private static void showTransaction(){
        Account account = selectAccount();
        if(account != null){
            account.showTransactions();
        }
    }
}
