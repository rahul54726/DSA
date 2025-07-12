package com.Rajpoot.Generics.comparing;

public class Main {
    public static void main(String[] args) {
        Student rahul=new Student(23246,8.86f);
        Student raj=new Student(23247,8.5f);
        if(raj.compareTo(rahul)==0){
            System.out.println("Rahul has more SGPS");
        }
    }
}
