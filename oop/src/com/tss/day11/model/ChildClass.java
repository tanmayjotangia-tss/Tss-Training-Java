package com.tss.day11.model;

public class ChildClass extends ParentClass {
    private int c;
    private int d;

    public ChildClass(){
        System.out.println("Child class called");
    }

    public ChildClass(int a, int b,int c ,int d){
        super(a,b);
        this.c=c;
        this.d =d;
    }
}
