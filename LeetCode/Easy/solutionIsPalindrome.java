package com.LeetCode.Easy;

public class solutionIsPalindrome {
    public static boolean isPalindrome(int x){
        int rem=0,rev=0;
        int original=x;
        if(x<0) {
            x=-1*x;
            original=-1*x;
        }
        while(x!=0){
            rem=x%10;
            rev=rem+rev*10;
            x/=10;
        }
        System.out.println(rev);
        return rev==original;
    }

    public static void main(String[] args) {
        int x=121;
        System.out.println(isPalindrome(x));
    }
}
