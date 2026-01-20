package com.tss.model;

public class Box {
    private double width,height,depth,volume;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public Box(){
        this.width=0.0;
        this.height=0.0;
        this.depth=0.0;
    }

    public Box(double width,double height,double depth){
        this.width=width;
        this.height=height;
        this.depth=depth;
    }

    public double volume(double width,double height,double depth){
        return volume = width*height*depth;
    }

    public void displayBoxInfo(){
        String information = this.width + "\n Box Height:" + this.height + "\nBox Depth:" + this.depth + "\nBox Volume" + this.volume;
        System.out.println(information);
    }
}
