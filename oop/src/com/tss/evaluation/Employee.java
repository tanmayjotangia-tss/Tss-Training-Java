package com.tss.evaluation;

public class Employee {
    private int id;
    private String name;
    private double salary;

    Employee(int id,String name,double salary){
        if(id < 0 || name.isEmpty() || salary < 0){
            System.out.println("Invalid values were pass");
            return;
        }
        this.id = id;
        this.name=name;
        this.salary=salary;
    }

    Employee(int id,String name){
        this(id,name,0);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        String str = "Employee ID:" + getId() + "Employee Name: " + getName() + "Employee Salary: " + getSalary();
        return str;
    }
}
