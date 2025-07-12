package com.Rahul.polymorphism;
public class Main {
    public static void main(String[] args) {
        Shapes shape=new Shapes();
        Circle circle=new Circle();
        Triangle triangle=new Triangle();
        Shapes square=new Square();
        shape.area();
        square.area();
        System.out.println(square);


    }
}
