package com.tss.day12.model;

import java.util.Random;

public abstract class Resource {
    private int resourceId;
    private String departmentName;
//    private double baseRate;
    private double usage;

    public Resource(String departmentName){
        setResourceId();
        this.departmentName=departmentName;
//        this.baseRate=baseRate;
    }

    public void setResourceId() {
        Random rand = new Random();
        this.resourceId = rand.nextInt(1_000_000);
    }

//    public double getBaseRate() {
//        return baseRate;
//    }

    public double getUsage() {
        return usage;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public abstract void enterUsage();
    public abstract void calculateCost();
    public abstract void generateBill();
}
