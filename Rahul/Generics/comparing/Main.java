package com.Rahul.Generics.comparing;

import com.Array.Array;
import com.Rahul.Interface.Annotations.A;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student rahul=new Student(23246,8.86f);
        Student raj=new Student(23247,8.5f);
        Student priyanshu = new Student(23245,8.4f);
        Student rohit = new Student(23252,8.7f);
        Student[] list ={rahul,rohit,priyanshu,raj};
        System.out.println(Arrays.toString(list));
        if(raj.compareTo(rahul)==0){
            System.out.println("Rahul has more SGPS");
        }
    }
}
