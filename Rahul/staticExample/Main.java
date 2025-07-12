package com.Rajpoot.staticExample;

public class Main {
    public static void main(String[] args) {
        Human rahul =new Human(22, "Rahul Rajpoot", 200000,true);
        Human raj =new Human(20, "Raj", 200000,false);
        Human priyashu =new Human(19, "Priyanshu", 200000,false);
        System.out.println(rahul.name);
        System.out.println(rahul.salary);
        System.out.println(rahul.population);
        System.out.println(Human.population);
//        NonStatic();
        Static();
    }

    static void Static(){
        Main ob=new Main();
//        ob.NonStatic();
        System.out.println("I'm  static that's why you are able to acess me ");
    }
    void NonStatic(){
        System.out.println("I'm not static that's why you are not able to acess me ");
        Static();
    }
}