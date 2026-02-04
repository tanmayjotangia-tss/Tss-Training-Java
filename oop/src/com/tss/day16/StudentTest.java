package com.tss.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTest {
    static void main() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(101,107125,"Tanmay"));
        studentList.add(new Student(105,107100,"Kris"));
        studentList.add(new Student(10,107108,"Uttam"));

        Collections.sort(studentList);

        for(Student student : studentList){
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------");

        Collections.sort(studentList,new StudentIdComparator());

        for(Student student : studentList){
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------");

        Collections.sort(studentList,new StudentNameComparator());
        for(Student student : studentList){
            System.out.println(student);
        }

    }
}
