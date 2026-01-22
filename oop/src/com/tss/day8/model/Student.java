package com.tss.day8.model;

import java.util.Random;

public class Student {

    private int id;
    private String name;

    private Course[] courses = new Course[3];
    private int courseCount = 0;

    private double[] courseFeesPaid = new double[3];


    public void generateStudentId(Student[] students, int studentCount) {
        Random random = new Random();

        while (true) {
            int generatedId = random.nextInt(100) + 1;
            boolean exists = false;

            for (int i = 0; i < studentCount; i++) {
                if (students[i].getId() == generatedId) {
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

    public String getName() {
        return name;
    }

    public Course[] getCourses() {
        return courses;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public boolean setName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        if (!name.matches("[a-zA-Z ]+")) return false;
        this.name = name.trim();
        return true;
    }

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
        courseFeesPaid[courseCount - 1] = 0;
        return true;
    }

    public boolean payFees(int courseId, double amount) {
        if (amount <= 0) return false;
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getId() == courseId) {
                double pending = courses[i].getFees() - courseFeesPaid[i];
                if (amount > pending) return false;
                courseFeesPaid[i] += amount;
                return true;
            }
        }
        return false;
    }


    public double getPendingFees(int courseId) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getId() == courseId) {
                return courses[i].getFees() - courseFeesPaid[i];
            }
        }
        return -1;
    }


    public void displayProfile() {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        if (courseCount == 0) {
            System.out.println("No courses opted.");
            return;
        }
        System.out.println("\nCourses Opted:");
        System.out.printf("%-10s %-20s %-12s %-12s %-12s%n",
                "ID", "Name", "Fees", "Paid", "Pending");

        for (int i = 0; i < courseCount; i++) {
            double pending = courses[i].getFees() - courseFeesPaid[i];
            System.out.printf("%-10d %-20s %-12.2f %-12.2f %-12.2f%n",
                    courses[i].getId(),
                    courses[i].getName(),
                    courses[i].getFees(),
                    courseFeesPaid[i],
                    pending);
        }
    }


//    public boolean replaceCourse(int oldCourseID,Course newCourse){
//        for (int i = 0; i < courseCount; i++) {
//            if(courses[i].getId()==newCourse.getId()){
//                System.out.println("Student already opted for this code");
//                return false;
//            }
//        }
//        for (int i = 0; i < courseCount; i++) {
//            if(courses[i].getId()==oldCourseID){
//                totalFees-=courses[i].getFees();
//                courses[i] = newCourse;
//                totalFees+=courses[i].getFees();
//                return true;
//            }
//        }
//        return false;
//    }
}