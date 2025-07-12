package com.Recursion;

public class FibonacciSeries {
    public static void main(String[] args) {
//        find nth fibonacii number
        System.out.println(fib(10));
//        System.out.println(fiboformula(10));

    }
    static int fiboformula(int n){
       return  (int)( Math.pow(((1+Math.sqrt(5))/2),n)/(Math.sqrt(5)));
    }
    static int fib(int n){
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
