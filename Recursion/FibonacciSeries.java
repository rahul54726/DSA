package com.Recursion;

import com.Array.Array;

import java.util.Arrays;

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
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    static int solve(int n , int[] dp){
        if(n<2) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n-1,dp)+solve(n-2,dp);
    }
}
