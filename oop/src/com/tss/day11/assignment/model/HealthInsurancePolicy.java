package com.tss.day11.assignment.model;

public class HealthInsurancePolicy extends Policy{
    private final int POLICY_PREMIUM_RATE=7;
    public HealthInsurancePolicy(String policyHolderName, double sumAssured, int policyDuration){
        super(policyHolderName, sumAssured, policyDuration);
    }

    @Override
    public double calculatePremium() {
        return (getSumAssured()*POLICY_PREMIUM_RATE)/100;
    }

    @Override
    public boolean processClaim() {
        return true;
    }
}
