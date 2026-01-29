package com.tss.day13.model;

public interface ElectricVehicle extends Vehicle{
    default void chargeBattery(){
        System.out.println("Charging Battery");
    }
}
