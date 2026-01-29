package com.tss.day13.model;

public interface NonElectricVehicle {
    default void getFuel(){
        System.out.println("Current fuel status");
    }
}
