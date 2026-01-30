package com.tss.day13.assignment.model;

public class Car extends AbstractVehicle {

    public Car(VehicleType type, boolean canPlayMusic, boolean canHonk) {
        super(type, canPlayMusic, canHonk);
    }

    @Override
    public void start() {
        if (!canStart()) {
            System.out.println("Car is already started");
            return;
        }
        markStarted();
        System.out.println("Car is started");
    }

    @Override
    public void stop() {
        if (!canStop()) {
            System.out.println("Car is not started yet");
            return;
        }
        markStopped();
        System.out.println("Car stopped");
    }

    @Override
    public void getType() {
        System.out.println(getVehicleType());
    }

    @Override
    public void horn() {
        if (!canHonk()) {
            System.out.println("This car cannot honk");
            return;
        }
        if (!canStart()) {
            System.out.println("Cannot honk as car is not started yet");
            return;
        }
        System.out.println("Car horns!!");
    }

    @Override
    public void playMusic() {
        if (!canPlayMusic()) {
            System.out.println("This car cannot play music");
            return;
        }
        if (!canStart()) {
            System.out.println("Cannot play music as car is not started yet");
            return;
        }
        System.out.println("Car is playing music");
    }
}
