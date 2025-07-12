package com.Recursion.Easy;

public class RevNumber {
    public static void main(String[] args) {
        System.out.println(reversenum(1342));
        System.out.println(revnum(1234));
    }
    static int sum=0;
    static int reversenum(int n){
        if(n==0){
            return 0;
        }
        int rem=n%10;
        sum=sum*10+rem;reversenum(n/10);
        return sum;
    }
    static int revnum(int n){
        int digit=(int)(Math.log10(n))+1;
        return helper(n,digit);
    }

    private static int helper(int n, int digit) {
        if(n%10==n){
            return n;
        }
        return (n%10)*(int)(Math.pow(10,digit-1))+helper(n/10,digit-1);
    }
}
