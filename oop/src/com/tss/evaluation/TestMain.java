package com.tss.evaluation;

class Test{
    static int num;


    static{
        System.out.println("Static block is called");
    }

    {
        System.out.println("Non-static block is called");
    }

    Test(){
        System.out.println("Constructor is called");
    }

    Test(String string){
        System.out.println("Parameterized constructor is called");
    }
}


class TestMain{
    public static void main(String args[]){

//        EvalTest t = new EvalTest();
//        EvalTest t2 = new EvalTest("Hello");
        System.out.println("Main class content");


    }
}
