package com.Rajpoot.encapsulation;

public class Main {
    public static void main(String[] args) {
        A obj=new A(10,"Rahul Rajpoot");
//        1. Access the data members
//        2.Modify the data members
//        System.out.println(obj.num);
        System.out.println(obj.getNum());
        obj.setNum(25);
        System.out.println(obj.getNum());


    }
}
