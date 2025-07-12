package com.Rahul.Interface.Annotations;

public interface A {
    static void greeting(){
        System.out.println("hello,i am static method");
    }
    default void fun(){
        System.out.println("I'm in A");
    }
}
