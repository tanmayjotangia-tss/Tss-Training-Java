package com.tss.day12.service;

import com.tss.day12.model.*;
import com.tss.utils.InputUtil;

public class AreaFinder {
    static void main() {

        int length = InputUtil.readInt("Enter Length");
        int breath = InputUtil.readInt("enter Breath");
        Shape rectangle = new Rectangle(length,breath);
        rectangle.area();

        Shape square = new Square(10);
        square.area();

        Shape triangle = new Triangle(20,40);
        triangle.area();
    }
}
