package com.tss.day12.model;

public class Square extends Shape{
    private int side;

    public Square(int side){
        this.side = side;
    }

    public void area(){
        System.out.println("Area of Square: " + (side*side));
    }
}
