package com.Recursion.Easy;

public class SumOfDig {
    public static void main(String[] args) {
        System.out.println(sum(143266));
        System.out.println(product(1430));
    }
    static int sum(int n){
        if(n==0) return 0;
        return n%10 + sum(n/10);
    }
    static int product(int n){
        if(n%10==n){
            return 1;
        }
        if(n==0) return 0;
        return n%10*product(n/10);
    }
}
