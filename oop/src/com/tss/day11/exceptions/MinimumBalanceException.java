package com.tss.day11.exceptions;

public class MinimumBalanceException extends RuntimeException {
    public MinimumBalanceException(double amount) {
        super(amount + " will be is below minimum balance.");
    }
}
