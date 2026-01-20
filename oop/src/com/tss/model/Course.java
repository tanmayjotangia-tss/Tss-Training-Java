package com.tss.model;

import java.util.Random;

public class Course {

    private int id;
    private String name;
    private double fees;
    private int duration;

    public Course() {
        this.id = new Random().nextInt(0,101);
    }

    public int getId() {
        return id;
    }

    public boolean setName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        if (!name.matches("[a-zA-Z ]+")) return false;
        this.name = name.trim();
        return true;
    }

    public boolean setFees(double fees) {
        if (fees <= 0) return false;
        this.fees = fees;
        return true;
    }

    public boolean setDuration(int duration) {
        if (duration <= 0) return false;
        this.duration = duration;
        return true;
    }

    public double getFees() {
        return fees;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.printf("%-10d %-20s %-12.2f %-10d%n",
                id, name, fees, duration);
    }
}
