package com.tss.day13.model;

import com.tss.utils.InputUtil;

import static com.tss.day13.model.VehicleFactory.createVehicle;

public class VehicleMenu {
    private static final int MAX_COUNT=10;
    private static Vehicle[] vehicles = new Vehicle[MAX_COUNT];
    private static int vehicleCount;

    static void main() {
        Vehicle v = null;
        System.out.println("Welcome to Vehicle menu");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Start Vehicle");
        System.out.println("3. Stop Vehicle");
        System.out.println("4. Get Fuel Status");
        System.out.println("5. Charge Battery");
        System.out.println("6. Blow Horn");
        System.out.println("7. Play Music");
        System.out.println("8. Perform Vehicle Inspection");

        int choice = InputUtil.readInt("Enter your choice: ");

        switch (choice){
            case 1: vehicles[vehicleCount++]= addVehicle();
            break;
            case 2: v.start();
            break;
            case 3: v.stop();
            break;
            case 4: v.getFuel();
            break;
        }
    }

    private static Vehicle addVehicle(){
        System.out.println("Vehicles available to be added");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");
        int vehicleChoice = InputUtil.readInt("Enter Choice:");

        System.out.println("Select type of Vehicle");
        System.out.println("1. Electric");
        System.out.println("2. Non-Electric");
        int typeChoice = InputUtil.readInt("Enter choice: ");

        return createVehicle(vehicleChoice,typeChoice);
    }
    private static Vehicle selectVehicle(){
        if (vehicleCount < 0){
            System.out.println("No vehicle found");
        }

        int vehicleNumber = InputUtil.readInt("Enter Vehicle Number: ");

        if(vehicleNumber < 0 || vehicleNumber > MAX_COUNT){
            System.out.println("Invalid Number");
        }

        return vehicles[vehicleNumber-1];
    }

    private static void performStart(){
        Vehicle v = selectVehicle();
        if(v!=null)v.start();
    }

    private static void performStop(){
        Vehicle v = selectVehicle();
        if (v != null) v.stop();
    }

    private static void getFuelStatus(){
        Vehicle v = selectVehicle();
        if (v != null) v.getFuel();
    }
}
