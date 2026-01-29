package com.tss.day12.model;

public class Triangle extends Shape {
    private int base,height;

    public Triangle(int base, int height){
        this.base=base;
        this.height=height;
    }



    public void area() {
        System.out.println("Area of Triangle: " + (base*height*0.5));
    }
}
