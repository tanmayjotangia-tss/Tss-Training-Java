package com.tss.day13.model;

import static com.tss.day13.model.VehicleType.*;

public class Car implements Vehicle,ElectricVehicle,NonElectricVehicle{
    private VehicleType type;
    public Car(VehicleType type){
        this.type = type;
    }
    @Override
    public void start() {
        System.out.println("Car is started");
    }

    @Override
    public void stop() {
        System.out.println("Car Stopped");
    }

    @Override
    public void getType() {
        System.out.println(type);
    }

    public void chargeBattery(){
        if(type == Electric){
            System.out.println("Car battery is charged");
        }else{
            System.out.println("Car is not electric");
        }
    }

    @Override
    public void getFuel() {
//        NonElectricVehicle.super.getFuel();
        if(type==NonElectric){
            System.out.println("Car's current fuel status");
        }else{
            System.out.println("Car is electric");
        }
    }
}
