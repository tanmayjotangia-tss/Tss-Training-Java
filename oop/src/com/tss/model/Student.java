package com.tss.model;

import java.util.Random;

public class Student {

    private int id;
    private String name;

    private Course[] courses = new Course[3];
    private int courseCount = 0;

    private double totalFees = 0;
    private double feesPaid = 0;

    public Student() {
        this.id = new Random().nextInt(1,101);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        if (!name.matches("[a-zA-Z ]+")) return false;
        this.name = name.trim();
        return true;
    }

    // MAX 3 COURSES PER STUDENT
    public boolean addCourse(Course course) {

        if (courseCount >= 3) {
            System.out.println("A student can opt for maximum 3 courses only.");
            return false;
        }

        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getId() == course.getId()) {
                System.out.println("Course already opted.");
                return false;
            }
        }

        courses[courseCount++] = course;
        totalFees += course.getFees();
        return true;
    }

    public boolean payFees(double amount) {
        if (amount <= 0) return false;
        if (feesPaid + amount > totalFees) return false;
        feesPaid += amount;
        return true;
    }

    public double getPendingFees() {
        return totalFees - feesPaid;
    }

    public void displayProfile() {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Total Fees   : " + totalFees);
        System.out.println("Fees Paid    : " + feesPaid);
        System.out.println("Pending Fees : " + getPendingFees());

        if (courseCount == 0) {
            System.out.println("No courses opted.");
            return;
        }

        System.out.println("\nCourses Opted:");
        System.out.printf("%-10s %-20s %-12s %-10s%n",
                "ID", "Name", "Fees", "Duration");

        for (int i = 0; i < courseCount; i++) {
            courses[i].display();
        }
    }
}