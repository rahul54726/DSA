package com.Rahul.staticExample;
//this is a demo to show initialisation of static variables
public class StaticBlock {
    static int a=4;
    static int b;
//    this static block will run only once when the first object is created i.e. when the class is loaded for the first time
    static {
        System.out.println("I'm in static block");
        b=a*5;
    }

    public static void main(String[] args) {
        StaticBlock boj=new StaticBlock();
        System.out.println(StaticBlock.a+" "+StaticBlock.b);
        StaticBlock.b+=3;
        StaticBlock obj2=new StaticBlock();
        System.out.println(StaticBlock.a+" "+StaticBlock.b);
    }
}
