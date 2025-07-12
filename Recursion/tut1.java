package com.Recursion;

public class tut1 {
    static int print(int n){
        if(n==5){
            return 5;
        }
        System.out.println(n);
//        recursive call
//        if you are calling a function again and again you can treat it as a seperate call in function;
       return print(n+1);
    }
    public static void main(String[] args) {
        System.out.println(print(1));
    }

}
