package com.tss.day11.service;

import com.tss.day11.exceptions.MinimumBalanceException;
import com.tss.day11.exceptions.NegativeAmountException;
import com.tss.day11.model.Account;
import com.tss.day11.model.SavingAccount;
import com.tss.day11.model.CurrentAccount;
import com.tss.utils.InputUtil;

public class MultiAccountApp {

    private static final int MAX_ACCOUNTS = 10;
    private static Account[] accounts = new Account[MAX_ACCOUNTS];
    private static int accountCount = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nWelcome to the banking app");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Transfer amount");
            System.out.println("7. Exit");

            int choice = InputUtil.readInt("Enter your choice:");

            switch (choice) {
                case 1:
                    while(true){
                        if (accountCount >= MAX_ACCOUNTS) {
                            System.out.println("Maximum accounts reached! Cannot create more accounts.");
                            break;
                        }
                        Account newAccount = createAccount();
                        if (newAccount != null) {
                            accounts[accountCount++] = newAccount;
                            System.out.println("Account created successfully!");
                        }
                        if(!InputUtil.createNext()){
                            break;
                        }

                    }break;

                case 2:
                    Account depAccount = selectAccount();
                    if (depAccount == null) {
                        break;
                    }
//
//                        while (true) {
//                            double amount = InputUtil.readDouble("Enter amount to deposit: ");
//
//                            if (amount > 0) {
//                                depAccount.deposit(amount);
//                                System.out.println("Deposit successful!");
//                                break;
//                            }
//                            System.out.println("Enter valid amount");
//                        }
//                        break;

                    while (true) {
                        try {
                            double amount = InputUtil.readDouble("Enter amount to deposit: ");
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
                    if (withAccount == null) {
                        break;
                    }
//                        while (true) {
//                            System.out.println("Current Balance: " + withAccount.getBalance());
//                            double amount = InputUtil.readDouble("Enter amount to withdraw: ");
//                            if (amount <= 0) {
//                                System.out.println("Enter a valid amount");
//                            } else if (amount > withAccount.getBalance()) {
//                                System.out.println("Insufficient balance!");
//                            } else if (withAccount instanceof CurrentAccount &&
//                                    withAccount.getBalance() - amount < CurrentAccount.MIN_BALANCE) {
//                                System.out.println("Enter valid amount (cannot go below minimum balance)");
//                            } else {
//                                withAccount.withdraw(amount);
//                                System.out.println("Withdrawal successful!");
//                                break;
//                            }
//                        }
//                        break;

                    while (true) {
                        try {
                            System.out.println("Current Balance: " + withAccount.getBalance());
                            double amount = InputUtil.readDouble("Enter amount to withdraw: ");
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
                    if (balAccount != null) {
                        System.out.println("Current Balance: " + balAccount.getBalance());
                        break;
                    }
                    break;

                case 5:
                    Account detailsAccount = selectAccount();
                    if (detailsAccount != null) {
                        detailsAccount.displayAccount();
                        break;
                    }
                    break;

                case 6:
                    if (accountCount < 2) {
                        System.out.println("Create minimum number of accounts first");
                    } else {
                        transferAmount();
                    }
                    break;

                case 7:
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

//    private static SavingAccount createSavingAccount() {
//        String name = InputUtil.readValidName("Enter Account Holder Name: ");
//        double balance;
//
//        while (true) {
//            balance = InputUtil.readDouble("Enter current balance:");
//            if (balance >= 0) {
//                break;
//            }
////            System.out.println("Invalid balance! Balance cannot be negative.");
//            throw new NegativeAmountException(balance);
//        }
//        return new SavingAccount(name, balance);
//    }

private static SavingAccount createSavingAccount() {
    String name = InputUtil.readValidName("Enter Account Holder Name: ");

    while (true) {
        try {
            double balance = InputUtil.readDouble("Enter current balance:");
            return new SavingAccount(name, balance);
        } catch (NegativeAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}

//    private static CurrentAccount createCurrentAccount() {
//        String name = InputUtil.readValidName("Enter Account Holder Name: ");
//        double balance;
//        while (true) {
//            balance = InputUtil.readDouble("Enter current balance:");
//            if (balance >= CurrentAccount.MIN_BALANCE) {
//                break;
//            }
////            System.out.println("Enter valid balance (minimum " + CurrentAccount.MIN_BALANCE + ")");
//            throw new MinimumBalanceException(balance);
//        }
//        return new CurrentAccount(name, balance);
//    }

private static CurrentAccount createCurrentAccount() {
    String name = InputUtil.readValidName("Enter Account Holder Name: ");

    while (true) {
        try {
            double balance = InputUtil.readDouble("Enter current balance:");
            return new CurrentAccount(name, balance);
        } catch (MinimumBalanceException | NegativeAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}


    private static Account selectAccount() {
        if (accountCount == 0) {
            System.out.println("No accounts available. Please create an account first.");
            return null;
        }

        System.out.println("Available Accounts:");
        for (int i = 0; i < accountCount; i++) {
            System.out.println("Account Number: " + accounts[i].getAccountNumber());
        }

        int accNumber = InputUtil.readInt("Enter the account number to select: ");

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNumber) {
                return accounts[i];
            }
        }

        System.out.println("Account not found!");
        return null;
    }

//    private static void transferAmount() {
//        System.out.println("Select Sender Account:");
//        Account sender = selectAccount();
//        if (sender == null) {
//            return;
//        }
//        Account receiver;
//        while (true) {
//            System.out.println("Select Receiver Account:");
//            receiver = selectAccount();
//
//            if (receiver == null) {
//                return;
//            }
//            if (sender == receiver) {
//                System.out.println("Self transfer not possible! Please select a different receiver account.");
//            } else {
//                break;
//            }
//        }
//
//        double amount;
//        while (true) {
//            System.out.println("Sender's current balance: " + sender.getBalance());
//            amount = InputUtil.readDouble("Enter amount to transfer: ");
//
//            if (amount <= 0) {
////                System.out.println("Invalid amount! Enter a positive value.");
//                throw new NegativeAmountException(amount);
//            }
//            else if (amount > sender.getBalance()) {
////                System.out.println("Insufficient balance!");
//                throw new MinimumBalanceException(amount);
//            }
//            else if (sender instanceof CurrentAccount &&
//                    sender.getBalance() - amount < CurrentAccount.MIN_BALANCE) {
////                System.out.println("Transfer not allowed! Minimum balance rule violated.");
//                throw new MinimumBalanceException(amount);
//            }
//            else {
//                break;
//            }
//        }
//        sender.withdraw(amount);
//        receiver.deposit(amount);
//        System.out.println("Transfer successful!");
//    }

private static void transferAmount() {
    System.out.println("Select Sender Account:");
    Account sender = selectAccount();
    if (sender == null) return;

    Account receiver;
    while (true) {
        System.out.println("Select Receiver Account:");
        receiver = selectAccount();
        if (receiver == null) return;

        if (sender != receiver) break;
        System.out.println("Self transfer not allowed!");
    }
    while (true) {
        try {
            System.out.println("Sender Balance: " + sender.getBalance());
            double amount = InputUtil.readDouble("Enter amount to transfer:");

            sender.withdraw(amount);
            receiver.deposit(amount);

            System.out.println("Transfer successful!");
            break;

        } catch (NegativeAmountException | MinimumBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}


}
