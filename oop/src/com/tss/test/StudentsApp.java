package com.tss.test;

import com.tss.model.Course;
import com.tss.model.Student;
import com.tss.utils.InputUtil;

public class StudentsApp {

    static Student[] students;
    static Course[] courses;

    static int studentIndex = 0;
    static int courseIndex = 0;

    public static void main(String[] args) {

        int totalStudents;
        int totalCourses;

        // ===== SYSTEM PROMPT 1 =====
        while (true) {
            totalStudents = InputUtil.readInt(
                    "How many students do you want to register ? ");
            if (totalStudents >= 1 && totalStudents <= 10) break;
            System.out.println("Enter a number between 1 and 10.");
        }

        // ===== SYSTEM PROMPT 2 =====
        while (true) {
            totalCourses = InputUtil.readInt(
                    "How many courses do you want to register ? ");
            if (totalCourses >= 1 && totalCourses <= 5) break;
            System.out.println("Enter a number between 1 and 5.");
        }

        students = new Student[totalStudents];
        courses = new Course[totalCourses];

        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1. Add a student");
            System.out.println("2. Add course");
            System.out.println("3. Assign course to student");
            System.out.println("4. Display Student Profile");
            System.out.println("5. Display all students");
            System.out.println("6. Display all courses");
            System.out.println("7. Pay Fees");
            System.out.println("8. View Pending Fees");
            System.out.println("9. Update course");
            System.out.println("10. Exit");

            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice) {
                case 1: addStudent(); break;
                case 2: addCourse(); break;
                case 3: assignCourseToStudent(); break;
                case 4: displayStudent(); break;
                case 5: displayAllStudents(); break;
                case 6: displayAllCourses(); break;
                case 7: payFees(); break;
                case 8: viewPendingFees(); break;
                case 9: updateCourse(); break;
                case 10:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ================= STUDENT =================

    private static void addStudent() {

        if (studentIndex >= students.length) {
            System.out.println("Student limit reached.");
            return;
        }

        Student student = new Student();

        while (true) {
            String name = InputUtil.readString("Student Name: ");
            if (student.setName(name)) break;
            System.out.println("Invalid name.");
        }

        students[studentIndex++] = student;
        System.out.println("Student added. ID: " + student.getId());
    }

    private static Student findStudentById() {

        if (studentIndex == 0) {
            System.out.println("No student found, create a student first.");
            return null;
        }

        while (true) {

            System.out.println("\nAvailable Students:");
            System.out.printf("%-10s %-20s%n", "ID", "Name");

            for (int i = 0; i < studentIndex; i++) {
                System.out.printf("%-10d %-20s%n",
                        students[i].getId(),
                        students[i].getName());
            }

            int id = InputUtil.readInt("Enter Student ID: ");

            for (int i = 0; i < studentIndex; i++) {
                if (students[i].getId() == id) {
                    return students[i];   // ✅ valid → exit method
                }
            }

            System.out.println("Invalid Student ID. Please try again.");
        }
    }




    // ================= COURSE =================

    private static void addCourse() {

        if (courseIndex >= courses.length) {
            System.out.println("Maximum course limit reached.");
            return;
        }

        Course course = new Course();

        while (true) {
            String name = InputUtil.readString("Course Name: ");
            if (course.setName(name)) break;
            System.out.println("Invalid name.");
        }

        while (true) {
            double fees = InputUtil.readDouble("Course Fees: ");
            if (course.setFees(fees)) break;
            System.out.println("Invalid fees.");
        }

        while (true) {
            int duration = InputUtil.readInt("Course Duration (months): ");
            if (course.setDuration(duration)) break;
            System.out.println("Invalid duration.");
        }

        courses[courseIndex++] = course;
        System.out.println("Course added. ID: " + course.getId());
    }

    private static Course findCourseById() {

        if (courseIndex == 0) {
            System.out.println("No course found, create a course first.");
            return null;
        }

        while (true) {

            System.out.println("\nAvailable Courses:");
            System.out.printf("%-10s %-20s%n", "ID", "Name");

            for (int i = 0; i < courseIndex; i++) {
                System.out.printf("%-10d %-20s%n",
                        courses[i].getId(),
                        courses[i].getName());
            }

            int id = InputUtil.readInt("Enter Course ID: ");

            for (int i = 0; i < courseIndex; i++) {
                if (courses[i].getId() == id) {
                    return courses[i];   // ✅ valid → exit method
                }
            }

            System.out.println("Invalid Course ID. Please try again.");
        }
    }




    // ================= ACTIONS =================

    private static void assignCourseToStudent() {

        Student student = findStudentById();
        if (student == null) return;

        Course course = findCourseById();
        if (course == null) return;

        if (student.addCourse(course)) {
            System.out.println("Course assigned successfully.");
        }
    }



    private static void displayStudent() {
        Student s = findStudentById();
        if (s != null) s.displayProfile();
    }

    private static void displayAllStudents() {

        if (studentIndex == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < studentIndex; i++) {
            System.out.println("\n--------------------");
            students[i].displayProfile();
        }
    }

    private static void displayAllCourses() {

        if (courseIndex == 0) {
            System.out.println("No courses available.");
            return;
        }

        System.out.printf("%-10s %-20s %-12s %-10s%n",
                "ID", "Name", "Fees", "Duration");

        for (int i = 0; i < courseIndex; i++) {
            courses[i].display();
        }
    }

    private static void payFees() {

        if (studentIndex == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        Student student = findStudentById();
        if (student == null) return;

        double pending = student.getPendingFees();

        if (pending == 0) {
            System.out.println("No pending fees, no payment required.");
            return;
        }

        while (true) {
            System.out.println("Pending Fees: " + pending);

            double amount = InputUtil.readDouble("Enter amount to pay: ");

            if (student.payFees(amount)) {
                System.out.println("Payment successful.");
                return;   // back to Main Menu
            }

            System.out.println("Invalid payment amount. Please try again.");
        }
    }


    private static void viewPendingFees() {
        Student s = findStudentById();
        if (s != null)
            System.out.println("Pending Fees: " + s.getPendingFees());
    }

    private static void updateCourse() {

        Course c = findCourseById();
        if (c == null) return;

        while (true) {
            String name = InputUtil.readString("New Course Name: ");
            if (c.setName(name)) break;
            System.out.println("Invalid name.");
        }

        while (true) {
            double fees = InputUtil.readDouble("New Fees: ");
            if (c.setFees(fees)) break;
            System.out.println("Invalid fees.");
        }

        while (true) {
            int duration = InputUtil.readInt("New Duration: ");
            if (c.setDuration(duration)) break;
            System.out.println("Invalid duration.");
        }

        System.out.println("Course updated successfully.");
    }
}