package com.Recursion.Easy;

public class NumOfZeroes {
    public static void main(String[] args) {
        int num=101011000;
        System.out.println(Zeroes(num));
    }
    static int Zeroes(int n){
        return helper(n,0);
    }

    private static int helper(int n, int c) {
        if(n==0){
            return c;
        }
        int rem=n%10;
        if(rem==0){
            return helper(n/10,c+1);
        }
        else {
            return helper(n/10,c);
        }
    }
}
