package com.BitManuplation;

public class EvenOdd {
    static boolean isEven(int num){
        return (num&1)==0;
    }
    public static void main(String[] args) {
        System.out.println(isEven(5));
    }
}
