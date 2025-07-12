package com.Recursion.Easy;

public class nto1 {
    public static void main(String[] args) {
        fun(5);
        revfun(5);
    }
    static  void fun(int n){
        if(n==0){
            return ;
        }
        fun(n-1);
        System.out.println(n);
    }
    static  void revfun(int n){
        if(n==0){
            return ;
        }
        System.out.println(n);
        fun(n-1);
    }
}
