package com.tss.day13.assignment.model;

public interface Vehicle {

    void start();
    void stop();
    void getType();
    int getVehicleNumber();

    default void horn(){
        System.out.println("Vehicle horns");
    }
    
    default void playMusic(){
        System.out.println("Vehicle playing music");
    }


    default void getFuel(){
        System.out.println("Current fuel status");
    }

    default void chargeBattery(){
        System.out.println("Charging Battery");
    }

    static void vehicleInspection(Vehicle vehicle){
        System.out.println("---- Vehicle Inspection Started ----");

        System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
        vehicle.getType();

        vehicle.horn();
        vehicle.playMusic();

        if (vehicle instanceof AbstractVehicle av) {
            av.chargeBattery();
            av.getFuel();
        }
        System.out.println("---- Vehicle Inspection Completed ----");
    }
}
