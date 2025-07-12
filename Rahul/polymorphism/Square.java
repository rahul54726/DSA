package com.Rahul.polymorphism;

public class Square extends Shapes{
    int a =50;
    int b=65;
    @Override
    void area(){
        System.out.println("Area of Square is a*a");
        System.out.println(a*b);
    }
}
