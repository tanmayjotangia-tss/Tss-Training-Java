package com.tss.evaluation;

public class EvalTest {
    public static void main(String[] args) {
        Object o = 100;
        if(o instanceof Integer){
            Integer n = (Integer)o;
            System.out.println("Integer " + n);
        }else {
            System.out.println("Can not typecast");
        }
    }
}
