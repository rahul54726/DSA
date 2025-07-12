package com.Rahul.encapsulation;

public class A {
    private int num;
    private String name;
    int[] arr;

    public int getNum() {
        return num;
    }
    public String getName(){
        return name;
    }
    public void setname(String newName){
        this.name=newName;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public A(int num, String name) {
        this.arr = new int[num];
        this.num = num;
        this.name = name;
    }
}
