package com.tss.day13.assignment.model;

public class VehicleFactory {
    private VehicleFactory() {}

    public static Vehicle createVehicle(int vehicleChoice, char typeChoice, boolean canPlayMusic, boolean canHonk) {

        VehicleType type = switch (typeChoice) {
            case 'a' -> VehicleType.Electric;
            case 'b' -> VehicleType.NonElectric;
            default -> throw new IllegalArgumentException("Invalid Option");
        };

        return switch (vehicleChoice) {
            case 1 -> new Car(type, canPlayMusic, canHonk);
            case 2 -> new Bike(type, canPlayMusic, canHonk);
            case 3 -> new Truck(type, canPlayMusic, canHonk);
            default -> throw new IllegalArgumentException("Invalid Option");
        };
    }
}
