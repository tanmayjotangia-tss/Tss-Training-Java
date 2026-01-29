package com.tss.day10.model;

public enum AccountType {
    SAVING("Saving Account"),
    CURRENT("Current Account");

    private String description;

    private AccountType(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

    public static void displayAccountType(){
        for(AccountType accType : AccountType.values()){
            System.out.println(accType + ":" + accType.getDescription());
        }
    }
}
