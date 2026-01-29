package com.tss.day11.assignment.model;

public class VehicleInsurancePolicy extends Policy {
    private boolean active;
    private final int POLICY_PREMIUM_RATE=3;

    public VehicleInsurancePolicy(String policyName,double sumAssured,int policyDuration,boolean active){
        super(policyName,sumAssured,policyDuration);
        this.active=active;
    }

    public double calculatePremium() {
        return (getSumAssured()*POLICY_PREMIUM_RATE)/100;
    }

    public boolean processClaim() {
        return active;
    }
}
