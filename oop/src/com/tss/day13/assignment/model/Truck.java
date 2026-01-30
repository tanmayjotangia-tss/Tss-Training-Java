package com.tss.day13.assignment.model;

public class Truck extends AbstractVehicle {

    public Truck(VehicleType type, boolean canPlayMusic, boolean canHonk) {
        super(type, canPlayMusic, canHonk);
    }

    @Override
    public void start() {
        if (!canStart()) {
            System.out.println("Truck is already started");
            return;
        }
        markStarted();
        System.out.println("Truck starts with BRRRR… CHUG-CHUG-CHUG");
    }

    @Override
    public void stop() {
        if (!canStop()) {
            System.out.println("Truck is not started yet");
            return;
        }
        markStopped();
        System.out.println("Truck stops with SKREEEECH!");
    }

    @Override
    public void getType() {
        System.out.println(getVehicleType());
    }

    @Override
    public void horn() {
        if (!canHonk()) {
            System.out.println("This truck cannot honk");
            return;
        }
        if (!canStart()) {
            System.out.println("Cannot honk as truck is not started yet");
            return;
        }
        System.out.println("HOOOONK! HOOOONK!");
    }

    @Override
    public void playMusic() {
        if (!canPlayMusic()) {
            System.out.println("This truck cannot play music");
            return;
        }
        if (!canStart()) {
            System.out.println("Cannot play music as truck is not started yet");
            return;
        }
        System.out.println("doo-doo-doo-doo-dooo");
    }
}
