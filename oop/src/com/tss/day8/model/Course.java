package com.tss.day8.model;

import java.util.Random;

public class Course {

    private int id;
    private String name;
    private double fees;
    private int duration;

    public void generateCourseId(Course[] courses, int courseCount) {
        Random random = new Random();

        while (true) {
            int generatedId = random.nextInt(100) + 1;
            boolean exists = false;

            for (int i = 0; i < courseCount; i++) {
                if (courses[i].getId() == generatedId) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                this.id = generatedId;
                return;
            }
        }
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
