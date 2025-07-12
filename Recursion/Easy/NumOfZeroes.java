package com.Recursion.Easy;

public class NumOfZeroes {
    public static void main(String[] args) {
//        int num=600542150;
//        System.out.println(zeroes(num));
//        System.out.println(numberOfZero(num));
        System.out.println(numberOfSteps(123));
    }
    static int zeroes(int n){
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
//    private static int count = 0;
//    static int numberOfZero(int num){
//        if(num == 0) return 0;
//        if(num%10==0){
//            count++;
//            numberOfZero(num/10);
//        }
//         else numberOfZero(numberOfZero(num/10));
//        return count;
//    }
    public static int numberOfSteps(int num) {
            return help(num,0);
    }

    private static int help(int num, int steps) {
        if(num == 0){
            return steps;
        }
        if(num % 2 == 0){
            return help(num/2,steps+1);
        }
        return help(num-1 ,steps+1);
    }
}
