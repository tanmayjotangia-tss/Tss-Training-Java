package com.tss.day12.model;

import com.tss.utils.InputUtil;

public class ElectricityResource extends Resource{
    private final double BASE_RATE=0.5;
    private double unitsConsumed;
    public ElectricityResource(String departmentName){
        super(departmentName);
    }

    @Override
    public void enterUsage() {
        unitsConsumed = InputUtil.readDouble("Enter Electricity units consumed");
    }


    @Override
    public void calculateCost() {
        double cost = unitsConsumed*BASE_RATE;

        if(unitsConsumed <=50){
            cost=0;
        }

        if(unitsConsumed > 300){
            cost *=1.2;
        }
    }

    @Override
    public void generateBill() {
        System.out.println("----------------Electricity Bill-------------");
        System.out.println("Resource Id: " + getResourceId());
        System.out.println("Department Name: " + getDepartmentName());
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println();

    }
}
