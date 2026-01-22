package com.tss.test;

import com.tss.model.Course;
import com.tss.model.Student;
import com.tss.utils.InputUtil;

import java.util.Scanner;

public class StudentsApp {

    static Student[] students;
    static Course[] courses;

    static int studentIndex = 0;
    static int courseIndex = 0;

    private static final int MAX_Students=10;
    private static final int MAX_Cources=5;

    static Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {

//        while (true) {
//            totalStudents = InputUtil.readInt("How many students do you want to register ? ");
//            if (totalStudents >= 1 && totalStudents <= 10) break;
//            System.out.println("Enter a number between 1 and 10.");
//        }
//        while (true) {
//            totalCourses = InputUtil.readInt("How many courses do you want to register ? ");
//            if (totalCourses >= 1 && totalCourses <= 5) break;
//            System.out.println("Enter a number between 1 and 5.");
//        }

        students = new Student[MAX_Students];
        courses = new Course[MAX_Cources];

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
//            System.out.println("9. Update course");
//            System.out.println("10. Update student course");
            System.out.println("0. Exit");

            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice) {
                case 1: {
                    boolean createMore = true;
                    while (createMore) {
                        addStudent();
                        String nextStudent;
                        while (true) {
                            System.out.print("Add next student? (yes/no): ");
                            nextStudent = scanner.nextLine().trim();
                            if (nextStudent.equalsIgnoreCase("yes")) {
                                break;
                            } else if (nextStudent.equalsIgnoreCase("no")) {
                                createMore = false;
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                            }
                        }
                    }
                    break;
                }
                case 2:{
                    boolean createMore = true;
                    while (createMore) {
                        addCourse();
                        String nextCourse;
                        while (true) {
                            System.out.print("Add next course? (yes/no): ");
                            nextCourse = scanner.nextLine().trim();
                            if (nextCourse.equalsIgnoreCase("yes")) {
                                break;
                            } else if (nextCourse.equalsIgnoreCase("no")) {
                                createMore = false;
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                            }
                        }
                    }
                    break;
                }
                case 3: assignCourseToStudent();
                        break;
                case 4: displayStudent();
                        break;
                case 5: displayAllStudents();
                        break;
                case 6: displayAllCourses();
                        break;
                case 7: payFees();
                        break;
                case 8: viewPendingFees();
                        break;
//                case 9: updateCourse();
//                        break;
//                case 10: updateStudentCourse();
//                        break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent() {
        if (studentIndex >= students.length) {
            System.out.println("Student limit reached.");
            return;
        }
        Student student = new Student();
        student.generateStudentId(students,studentIndex);
        while (true) {
            String name = InputUtil.readString("Student Name: ");
            if (student.setName(name)) break;
            System.out.println("Invalid name.");
        }
        students[studentIndex++] = student;
        System.out.println("Student added");
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
                    return students[i];
                }
            }
            System.out.println("Invalid Student ID. Please try again.");
        }
    }

    private static void addCourse() {
        if (courseIndex >= courses.length) {
            System.out.println("Maximum course limit reached.");
            return;
        }
        Course course = new Course();
        course.generateCourseId(courses,courseIndex);

        while (true) {
            String name = InputUtil.readString("Course Name: ");
            if (isCourseNameExists(name)) {
                System.out.println("Course with this name already exists. Please enter a different name.");
                continue;
            }
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
        System.out.println("Course added.");
    }

    private static boolean isCourseNameExists(String name) {
        for (int i = 0; i < courseIndex; i++) {
            if (courses[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
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
                    return courses[i];
                }
            }
            System.out.println("Invalid Course ID. Please try again.");
        }
    }

    private static void assignCourseToStudent() {
        if (courseIndex == 0) {
            System.out.println("No courses available. Create a course first.");
            return;
        }
        Student student = findStudentById();
        if (student == null) return;
        while(true){
            Course course = findCourseById();
            if (course == null) return;
            if (student.addCourse(course)) {
                System.out.println("Course assigned successfully.");
                break;
            }
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
        System.out.printf("%-10s %-20s %-12s %-10s%n", "ID", "Name", "Fees", "Duration");
        for (int i = 0; i < courseIndex; i++) {
            courses[i].display();
        }
    }

    private static void payFees() {
        Student student = findStudentById();
        if (student == null) return;

        if (student.getCourseCount() == 0) {
            System.out.println("No courses opted.");
            return;
        }
        student.displayProfile();
        while (true) {
            int courseId = InputUtil.readInt("Enter Course ID to pay fees: ");
            double pending = student.getPendingFees(courseId);
            if (pending < 0) {
                System.out.println("Invalid Course ID.");
                continue;
            }
            if (pending == 0) {
                System.out.println("No pending fees for this course.");
                return;
            }
            System.out.println("Pending Fees: " + pending);
            while (true) {
                double amount = InputUtil.readDouble("Enter amount to pay: ");
                if (student.payFees(courseId, amount)) {
                    System.out.println("Payment successful.");
                    return;
                }
                System.out.println("Invalid payment amount.");
            }
        }
    }


    private static void viewPendingFees() {
        Student student = findStudentById();
        if (student == null) return;
        if (student.getCourseCount() == 0) {
            System.out.println("No courses opted.");
            return;
        }

        student.displayProfile();
    }


//    private static void updateCourse() {
//        Course c = findCourseById();
//        if (c == null) return;
//
//
//        while (true) {
//            double fees = InputUtil.readDouble("New Fees: ");
//            if (c.setFees(fees)) break;
//            System.out.println("Invalid fees.");
//        }
//
//        while (true) {
//            int duration = InputUtil.readInt("New Duration: ");
//            if (c.setDuration(duration)) break;
//            System.out.println("Invalid duration.");
//        }
//        System.out.println("Course updated successfully.");
//    }
//    private static void updateStudentCourse(){
//
//        if(studentIndex==0){
//            System.out.println("No student available");
//            return;
//        }
//        Student student = findStudentById();
//        if(student==null)return;
//        if(student.getCourseCount()==0){
//            System.out.println("The student has not opted for any course");
//            return;
//        }
//
//        System.out.println("\nCourses opted by the student");
//        System.out.printf("%-10s %-20s %-12s %-10s%n","ID","Name","Fees","Duration");
//        Course[] studentCourse = student.getCourses();
//
//        int studentCourseCount = student.getCourseCount();
//
//        for (int i = 0; i < studentCourseCount; i++) {
//            studentCourse[i].display();
//        }
//
//        int oldCourseId;
//        while(true){
//            oldCourseId=InputUtil.readInt("Enter the course ID to replace");
//            boolean found=false;
//
//            for (int i = 0; i < studentCourseCount; i++) {
//                if(studentCourse[i].getId()==oldCourseId){
//                    found=true;
//                    break;
//                }
//            }
//            if(found)break;
//            System.out.println("Invalid Course Id,please try again");
//        }
//
//        System.out.println("\nAvailable Courses in system");
//        System.out.printf("%-10s %-20s %-12s %-10s%n","ID","Name","Fees","Duration");
//        for (int i = 0; i < courseIndex; i++) {
//            courses[i].display();
//        }
//
//        Course newCourse = null;
//        while(true){
//            int newCourseId=InputUtil.readInt("Enter new Course ID to assign:");
//            for (int i = 0; i < courseIndex; i++) {
//                if(courses[i].getId()==newCourseId){
//                    newCourse=courses[i];
//                    break;
//                }
//            }
//            if(newCourse!=null)break;
//            System.out.println("Invalid Course ID,Please Try again");
//            }
//        if(student.replaceCourse(oldCourseId,newCourse)){
//            System.out.println("Course Replaced");
//        }
//    }
}