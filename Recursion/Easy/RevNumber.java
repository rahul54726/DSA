package com.Recursion.Easy;

public class RevNumber {
    private static int sum=0;
    static int reversenum(int n){
        if(n==0){
            return 0;
        }
        int rem=n%10;
        sum=sum*10+rem;
        reversenum(n/10);
        return sum;
    }
    static int digits(int n){
        int count = 0;
        while(n!=0){
            count++;
            n/=10;
        }
        return count;
    }
    static int revnum(int n){
//        int digit=(int)(Math.log10(n))+1;
        int digit=digits(n);
        return helper(n,digit);
    }

    private static int helper(int n, int digit) {
        if(n%10==n){
            return n;
        }
        return (n%10)*(int)(Math.pow(10,digit-1))+helper(n/10,digit-1);
    }
    static  boolean isPallindeome(int num){
        return num == revnum(num);
    }
    public static void main(String[] args) {
        System.out.println(reversenum(1342));
        System.out.println(revnum(1234));
        System.out.println(isPallindeome(12321));
    }
}
