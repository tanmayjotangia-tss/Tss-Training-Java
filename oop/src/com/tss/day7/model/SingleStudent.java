package com.tss.day7.model;

public class SingleStudent {

    private int id;
    private double feesPaid;
    private double totalFees;
    private String name;
    private String course;

    public boolean setId(int id) {
        if (id <= 0) return false;
        this.id = id;
        return true;
    }

    public boolean setName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        if (!name.matches("[a-zA-Z ]+")) return false;
        this.name = name.trim();
        return true;
    }

    public boolean setCourse(String course) {
        if (course == null || course.trim().isEmpty()) return false;
        if (!course.matches("[a-zA-Z ]+")) return false;
        this.course = course.trim();
        return true;
    }

    public boolean setFeesPaid(double feesPaid) {
        if (feesPaid < 0) return false;
        if (totalFees > 0 && feesPaid > totalFees) return false;
//        if(!feesPaid.matches(regex: "[1-9]"))
        this.feesPaid = feesPaid;
        return true;
    }

    public boolean setTotalFees(double totalFees) {
        if (totalFees <= 0) return false;
        if (feesPaid > totalFees) return false;
        this.totalFees = totalFees;
        return true;
    }

    public int getId() {
        return id;
    }
    public double getFeesPaid() {
        return feesPaid;
    }
    public double getTotalFees() {
        return totalFees;
    }
    public String getName() {
        return name;
    }
    public String getCourse() {
        return course;
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
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Course: " + course);
        System.out.println("Fees Paid: " + feesPaid);
        System.out.println("Total Fees: " + totalFees);
    }

    public void displayProfileTable(){
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%-12s %-20s %-20s %-12s %-12s%n",
                "ID", "Name", "Course", "Fees Paid", "Total Fees");
        System.out.println("----------------------------------------------------------------------------------------");

        System.out.printf("%-12d %-20s %-20s %-12.2f %-12.2f%n",
                id, name, course, feesPaid, totalFees);

        System.out.println("----------------------------------------------------------------------------------------");

    }
}
