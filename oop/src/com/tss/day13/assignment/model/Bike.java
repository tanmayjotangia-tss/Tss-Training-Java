package com.tss.day13.assignment.model;

public class Bike extends AbstractVehicle {

    public Bike(VehicleType type, boolean canPlayMusic, boolean canHonk) {
        super(type, canPlayMusic, canHonk);
        if (!canPlayMusic) {
            this.canPlayMusic = false;
        }
    }

    @Override
    public void start() {
        if (!canStart()) {
            System.out.println("Bike is already started");
            return;
        }
        markStarted();
        System.out.println("Bike starts!!");
    }

    @Override
    public void stop() {
        if (!canStop()) {
            System.out.println("Bike is not started yet");
            return;
        }
        markStopped();
        System.out.println("Bike stops");
    }

    @Override
    public void getType() {
        System.out.println(getVehicleType());
    }

    @Override
    public void horn() {
        if (!canHonk()) {
            System.out.println("This bike cannot honk");
            return;
        }
        if (!canStart()) {
            System.out.println("Cannot honk as bike is not started yet");
            return;
        }
        System.out.println("Bike beeps!!");
    }

    @Override
    public void playMusic() {
        if (!canPlayMusic()) {
            System.out.println("Bike can't play music");
            return;
        }
        if (!canStart()) {
            System.out.println("Cannot play music as bike is not started yet");
            return;
        }
        System.out.println("Bike is playing music");
    }
}
