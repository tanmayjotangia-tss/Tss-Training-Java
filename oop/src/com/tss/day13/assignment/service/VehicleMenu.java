package com.tss.day13.assignment.service;

import com.tss.day13.assignment.model.AbstractVehicle;
import com.tss.day13.assignment.model.Vehicle;
import com.tss.day13.assignment.model.VehicleType;
import com.tss.day13.assignment.util.InputUtil;

import static com.tss.day13.assignment.model.Vehicle.vehicleInspection;
import static com.tss.day13.assignment.model.VehicleFactory.createVehicle;

public class VehicleMenu {
    private static final int MAX_COUNT=10;
    private static Vehicle[] vehicles = new Vehicle[MAX_COUNT];
    private static int vehicleCount;

    static void main() {
        while(true){
            System.out.println("\nWelcome to Vehicle menu");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Display All Vehicle");
            System.out.println("3. Display Vehicle By Number");
            System.out.println("4. Start Vehicle");
            System.out.println("5. Stop Vehicle");
            System.out.println("6. Get Fuel Status");
            System.out.println("7. Charge Battery");
            System.out.println("8. Blow Horn");
            System.out.println("9. Play Music");
            System.out.println("10. Perform Vehicle Inspection");
            System.out.println("11. Exit");

            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice){
                case 1: while(true){
                    if(vehicleCount >= MAX_COUNT){
                        break;
                    }
                    vehicles[vehicleCount++]= addVehicle();
                    System.out.println("Vehicle added Successfully !!");
                    if(!InputUtil.createNext()){
                        break;
                    }
                }
                    break;
                case 2: showAllVehicles();
                    break;
                case 3: displaySingleVehicle();
                    break;
                case 4: performStart();
                    break;
                case 5: performStop();
                    break;
                case 6: getFuelStatus();
                    break;
                case 7: performChargeBattery();
                    break;
                case 8: blowHorn();
                    break;
                case 9: performPlayMusic();
                    break;
                case 10: performVehicleInspection();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static Vehicle addVehicle() {
        int vehicleChoice;
        char typeChoice;

        while (true) {
            System.out.println("Vehicles available to be added");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            vehicleChoice = InputUtil.readInt("Enter Choice: ");
            if (vehicleChoice >= 1 && vehicleChoice <= 3) {
                break;
            }
            System.out.println("Enter within range of 1-3");
        }

        while (true) {
            System.out.println("Select type of Vehicle");
            System.out.println("a. Electric");
            System.out.println("b. Non-Electric");
            typeChoice = InputUtil.readChar("Enter choice: ");
            if (typeChoice == 'a' || typeChoice == 'b') {
                break;
            }
            System.out.println("Enter either a or b");
        }

        boolean canPlayMusic = InputUtil.readBoolean("Can the vehicle play music? (yes/no): ");
        boolean canHonk = InputUtil.readBoolean("Can the vehicle honk? (yes/no): ");

        return createVehicle(vehicleChoice, typeChoice, canPlayMusic, canHonk);
    }



    private static void showAllVehicles(){
        if (vehicleCount == 0){
            System.out.println("No vehicle found");
        }
        System.out.println("Available Vehicles");
        for (int i = 0; i < vehicleCount; i++) {
            System.out.println(vehicles[i].toString());
        }
    }

    private static void showVehicleNumbers() {
        if(vehicleCount == 0){
            System.out.println("No vehicles available.");
            return;
        }
        System.out.println("Available Vehicle Numbers:");
        for(int i = 0; i < vehicleCount; i++){
            System.out.println("Vehicle Number: " + vehicles[i].getVehicleNumber());
        }
    }

    private static void displaySingleVehicle() {
        Vehicle v = findVehicleByNumber();
        if(v != null){
            System.out.println("\nVehicle Details:");
            System.out.println(v);
        }
    }

    private static Vehicle findVehicleByNumber() {
        if (vehicleCount == 0) {
            System.out.println("No vehicles available.");
            return null;
        }
        Vehicle v = null;
        while (v == null) {
            showVehicleNumbers();
            int number = InputUtil.readInt("Enter Vehicle number: ");

            for (int i = 0; i < vehicleCount; i++) {
                if (vehicles[i].getVehicleNumber() == number) {
                    v = vehicles[i];
                    break;
                }
            }
            if (v == null) {
                System.out.println("Invalid vehicle number, please enter a number from the list above.");
            }
        }
        return v;
    }

    private static void performStart(){
        Vehicle v = findVehicleByNumber();
        if(v!=null)v.start();
    }

    private static void performStop(){
        Vehicle v = findVehicleByNumber();
        if (v != null) v.stop();
    }

    private static void getFuelStatus(){
        Vehicle v = findVehicleByNumber();
        if (v != null) {
            if(v instanceof AbstractVehicle av){
                if(av.type== VehicleType.NonElectric){
                    v.getFuel();
                }else{
                    System.out.println("No Fuel Tank present in Electric Vehicle");
                }
            }
        };
    }

    public static void performChargeBattery(){
        Vehicle v = findVehicleByNumber();
        if(v != null){
            if(v instanceof AbstractVehicle av){
                if(av.type==VehicleType.Electric)av.chargeBattery();
            }else{
                System.out.println("No battery present in Non-Electric Vehicle");
            }
        }
    }

    private static void blowHorn(){
        Vehicle v = findVehicleByNumber();
        if(v!=null)v.horn();
    }

    private static void performPlayMusic(){
        Vehicle v = findVehicleByNumber();
        if(v!=null)v.playMusic();
    }

    private static void performVehicleInspection(){
        Vehicle v =findVehicleByNumber();
        if(v != null)vehicleInspection(v);
    }
}
