package com.Rahul.staticExample;

public class Human {
    int age ;
    String name;
    double salary;
    boolean married;
    static long population;
    static void message(){
        System.out.println("Namastey");
//        System.out.println(this.age);
//        cant use this over here this represents an object and static dont belong to any obj
    }
    Human(int age ,String name,double salary,boolean married){
        this.age=age;
        this.name=name;
        this.salary=salary;
        Human.population+=1;
    }
}
