package com.tss.day11.assignment.service;

import com.tss.day11.assignment.model.HealthInsurancePolicy;
import com.tss.day11.assignment.model.LifeInsurancePolicy;
import com.tss.day11.assignment.model.Policy;
import com.tss.day11.assignment.model.VehicleInsurancePolicy;
import com.tss.utils.InputUtil;

public class InsuranceApp {
    private static final int MAX_POLICIES=10;
    static Policy[] policies = new Policy[MAX_POLICIES];
    static int policyCount=0;
    static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Insurance System");
            System.out.println("1. Add Insurance Policy");
            System.out.println("2. Calculate and Display Premium");
            System.out.println("3. Apply for Policy Claim");
            System.out.println("4. Display Policy Details");
            System.out.println("5. Exit");

            int choice = InputUtil.readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    while (true) {
                        if (policyCount >= MAX_POLICIES) {
                            System.out.println("Policy limit reached");
                            break;
                        }
                        createPolicy();
                        if(!InputUtil.createNext()){
                            break;
                        }
                    }
                    break;

                case 2: calculatePremium();
                    break;

                case 3: applyClaim();
                    break;

                case 4: displayPolicy();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private static void createPolicy() {
        while (true) {
            System.out.println("Select policy type:");
            System.out.println("a. Life Insurance");
            System.out.println("b. Health Insurance");
            System.out.println("c. Vehicle Insurance");

            char policyChoice = InputUtil.readChar("Enter your choice: ");

            switch (policyChoice) {
                case 'a': {
                    String policyName = InputUtil.readValidName("Enter policy holder name: ");
                    double sumAssured = InputUtil.readDouble("Enter assured amount: ");
                    int policyDuration = InputUtil.readInt("Enter policy duration: ");
                    int yearsCompleted = InputUtil.readInt("Enter years completed: ");
                    policies[policyCount++] = new LifeInsurancePolicy(policyName, sumAssured, policyDuration, yearsCompleted);
                    System.out.println("Life Insurance Policy created successfully!");
                    return;
                }
                case 'b': {
                    String policyName = InputUtil.readValidName("Enter policy holder name: ");
                    double sumAssured = InputUtil.readDouble("Enter assured amount: ");
                    int policyDuration = InputUtil.readInt("Enter policy duration: ");
                    policies[policyCount++] = new HealthInsurancePolicy(policyName, sumAssured, policyDuration);
                    System.out.println("Health Insurance Policy created successfully!");
                    return;
                }
                case 'c': {
                    String policyName = InputUtil.readValidName("Enter policy holder name: ");
                    double sumAssured = InputUtil.readDouble("Enter assured amount: ");
                    int policyDuration = InputUtil.readInt("Enter policy duration: ");
                    boolean active = InputUtil.readBoolean("Is policy active ? ");
                    policies[policyCount++] = new VehicleInsurancePolicy(policyName, sumAssured, policyDuration, active);
                    System.out.println("Vehicle Insurance Policy created successfully!");
                    return;
                }
                default:
                    System.out.println("Invalid policy type. Please enter a, b, or c.");
            }
        }
    }


    private static Policy findPolicy() {
        if (policyCount == 0) {
            System.out.println("No policies available.");
            return null;
        }
        displayAvailablePolicyNumbers();

        while (true) {
            int policyNumber = InputUtil.readInt("Enter policy number: ");
            for (int i = 0; i < policyCount; i++) {
                if (policies[i] != null && policies[i].getPolicyNumber() == policyNumber) {
                    return policies[i];
                }
            }
            System.out.println("Invalid policy number. Try again.");
        }
    }

        private static void calculatePremium() {
        Policy policy = findPolicy();
        if (policy == null) {
            System.out.println("Invalid policy");
            return;
        }
        System.out.println("Annual Premium: " + policy.calculatePremium());
    }

    private static void applyClaim() {
        Policy policy = findPolicy();
        if (policy == null) {
            System.out.println("Invalid policy");
            return;
        }
        double amount;
        while(true){
            amount = InputUtil.readDouble("Enter amount to be claimed");
            if(amount <= policy.getSumAssured()) break;
            System.out.println("Enter valid amount");
        }


//        System.out.println(policy.processClaim()?"Claim Approved" : "Claim Rejected");
        if(policy.processClaim()){
            policy.setSumAssured(policy.getSumAssured()-amount);
            System.out.println("Claim Approved");
        }else{
            System.out.println("Claim Rejected");
        }
    }

    private static void displayPolicy() {
        Policy policy = findPolicy();
        if (policy == null) {
            System.out.println("Invalid policy");
            return;
        }
        policy.displayPolicy();
    }

    private static void displayAvailablePolicyNumbers() {
        if (policyCount == 0) {
            System.out.println("No policies available.");
            return;
        }
        System.out.println("Available Policy Numbers:");
        for (int i = 0; i < policyCount; i++) {
            System.out.println("- " + policies[i].getPolicyNumber());
        }
    }
}
