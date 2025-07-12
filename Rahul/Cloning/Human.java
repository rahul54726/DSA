package com.Rahul.Cloning;

public class Human implements Cloneable{
    String name;
    int age;
    int[] arr;


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.arr=new int[]{1,2,5,6,4};
    }
    public Human(Human other ){
        this.name=other.name;
        this.age=other.age;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
