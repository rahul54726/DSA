package com.Rahul.abstraction;

public  class Son extends Parent{
    @Override
    void carrier(String name) {
        System.out.println("I'm going to be a "+name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I Love " + name+" and she is "+age+" years old");
    }
    void  normal(){
        System.out.println("this is Normal");
    }
    @Override
    void live(String city) {
        System.out.println("And i'll live in "+city + " after my study will finish");
    }
}
