package com.tss.day11.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private static int idCount = 0;

    private String type;
    private int transactionId;
    private int senderAccountNumber;
    private int recieverAccountNumber;
    private final double balanceBefore;
    private final double balanceAfter;
    private double amount;
    private LocalDateTime transactionDateTime;


    // Deposit / Withdraw
    public Transaction(String type, int senderAccountNumber, double amount, double balancebefore, double balanceAfter) {

        this.transactionId = ++idCount;
        this.type = type;
        this.senderAccountNumber = senderAccountNumber;
        this.amount = amount;
        this.balanceBefore = balancebefore;
        this.balanceAfter = balanceAfter;
        this.transactionDateTime = LocalDateTime.now();

    }

    // Transfer
    public Transaction(String type, int senderAccountNumber, int recieverAccountNumber, double amount, double balancebefore, double balanceAfter) {

        this(type, senderAccountNumber, amount, balancebefore, balanceAfter);
        this.recieverAccountNumber = recieverAccountNumber;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                "\nType: " + type +
                "\nSender Account: " + senderAccountNumber +
                (recieverAccountNumber != 0 ? "\nReceiver Account: " + recieverAccountNumber : "") +
                "\nAmount: " + amount +
                "\nBalance Before: " + balanceBefore +
                "\nBalance After: " + balanceAfter +
                "\n-----------------------------";
    }

    public static void printTableHeader() {
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s %-19s %-10s %-12s %-12s %-12s %-15s %-15s%n",
                "ID", "DATE & TIME", "TYPE", "FROM", "TO", "AMOUNT", "BAL BEFORE", "BAL AFTER");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public void printTableRow() {

        String sender =
                (senderAccountNumber == 0) ? "-" : String.valueOf(senderAccountNumber);

        String receiver =
                (recieverAccountNumber == 0) ? "-" : String.valueOf(recieverAccountNumber);

        System.out.printf(
                "%-4d %-19s %-10s %-12s %-12s %-12.2f %-15.2f %-15.2f%n",
                transactionId,
                transactionDateTime.format(FORMATTER),
                type,
                sender,
                receiver,
                amount,
                balanceBefore,
                balanceAfter
        );
    }



    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


}
