package com.tss.day13.model;

public class VehicleFactory {
    private VehicleFactory() {}

    public static Vehicle createVehicle(int vehicleChoice, int typeChoice){
        VehicleType type =  switch (typeChoice) {
            case 1 -> VehicleType.Electric;
            case 2 -> VehicleType.NonElectric;
            default -> throw new IllegalArgumentException("Invalid Option");
        };

        return switch (vehicleChoice){
            case 1 -> new Car(type);
//            case 2 -> new Bike(type);
//            case 3 -> new Truck(type)
            default -> throw new IllegalArgumentException("Invalid Option");
        };
    }
}
