package com.tss.day16;

public class Student implements Comparable<Student> {
    private int id;
    private int rollno;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollno=" + rollno +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, int rollno, String name) {
        this.id = id;
        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        if(this.rollno > student.getRollno())
            return 1;
        if(this.rollno < student.getRollno())
            return -1;

        return 0;
    }
}
