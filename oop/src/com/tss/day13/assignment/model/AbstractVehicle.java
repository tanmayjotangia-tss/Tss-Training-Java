package com.tss.day13.assignment.model;

import java.util.Random;

import static com.tss.day13.assignment.model.VehicleType.Electric;
import static com.tss.day13.assignment.model.VehicleType.NonElectric;

public abstract class AbstractVehicle implements Vehicle {
    public VehicleType type;
    protected int vehicleNumber;
    protected boolean isStarted;
    protected boolean canPlayMusic;
    protected boolean canHonk;


    AbstractVehicle(VehicleType type, boolean canPlayMusic, boolean canHonk) {
        this.vehicleNumber = vehicleNumberGenerator();
        this.type = type;
        this.isStarted = false;
        this.canPlayMusic = canPlayMusic;
        this.canHonk = canHonk;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    protected boolean canStart() {
        return !isStarted;
    }

    protected boolean canStop() {
        return isStarted;
    }

    protected void markStarted() {
        isStarted = true;
    }

    protected void markStopped() {
        isStarted = false;
    }

    public VehicleType getVehicleType() {
        return type;
    }

    public boolean canPlayMusic() {
        return canPlayMusic;
    }

    public boolean canHonk() {
        return canHonk;
    }

    @Override
    public void chargeBattery() {
        if (type == Electric) {
            System.out.println("Battery is charged");
        } else {
            System.out.println("No battery present due to being Non-Electric");
        }
    }

    @Override
    public void getFuel() {
        if (type == NonElectric) {
            System.out.println("Fuel Tank status");
        } else {
            System.out.println("No fuel tank present due to being Electric");
        }
    }

    public static int vehicleNumberGenerator() {
        Random rand = new Random();
        return rand.nextInt(1_000_000);
    }

    @Override
    public String toString() {
        return "Vehicle Number: " + vehicleNumber + ", Class: " + getClass().getSimpleName() + ", Type: " + type + ", Started: " + isStarted + ", Can Play Music: " + canPlayMusic + ", Can Honk: " + canHonk;
    }
}
