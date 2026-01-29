package com.tss.day11.assignment.model;

public class LifeInsurancePolicy extends Policy{
    private int yearsCompleted;
    private final double POLICY_PREMIUM_RATE=5;

    public LifeInsurancePolicy(String policyName, double sumAssured, int policyDuration, int yearsCompleted) {
        super(policyName,sumAssured,policyDuration);
        this.yearsCompleted=yearsCompleted;

    }

    public double calculatePremium() {
        return (getSumAssured()*POLICY_PREMIUM_RATE)/100;
    }

    public boolean processClaim() {
        return yearsCompleted >= getPolicyDuration();
    }
}
