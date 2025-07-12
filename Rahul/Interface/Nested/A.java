package com.Rahul.Interface.Nested;

import java.util.Scanner;

public class A {
    //nested interface
    public interface NestedInterface{
        boolean isOdd(int num);
    }
}
class B implements  A.NestedInterface{

    @Override
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        B check= new B();
        System.out.println(check.isOdd(num));
    }
}
