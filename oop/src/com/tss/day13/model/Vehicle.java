package com.tss.day13.model;

public interface Vehicle {

    void start();
    void stop();
    void getType();

    default void horn(){
        System.out.println("Vehicle horns");
    }
    default void playMusic(){
        System.out.println("Vehicle playing music");
    }
}
