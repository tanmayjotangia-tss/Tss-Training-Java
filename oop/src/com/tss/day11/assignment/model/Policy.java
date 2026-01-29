package com.tss.day11.assignment.model;

import java.util.Random;

public abstract class Policy {
    private int policyNumber,policyDuration;
    private String policyName;
    private double sumAssured;

    public Policy(String policyName,double sumAssured,int policyDuration){
        setPolicyNumber();
        this.policyName=policyName;
        this.sumAssured =sumAssured;
        this.policyDuration=policyDuration;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber() {
        Random rand = new Random();
        this.policyNumber = rand.nextInt(100_000_000);
    }
    public int getPolicyDuration() {
        return policyDuration;
    }
    public double getSumAssured() {
        return sumAssured;
    }
    public void setSumAssured(double sumAssured) {
        this.sumAssured = sumAssured;
    }

    public void displayPolicy(){
        System.out.println("Policy Number: "+policyNumber);
        System.out.println("Policy Name: "+policyName);
        System.out.println("Sum Assured: "+ sumAssured);
        System.out.println("Policy Duration: "+policyDuration);

    }

    public abstract  double calculatePremium();
    public abstract boolean processClaim();
}
