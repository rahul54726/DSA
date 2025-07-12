package com.LeetCode.TWOPOINTER;

public class ValidPallindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("n a 6464m a n "));
    }
    public static boolean isPalindrome(String s) {
        s=s.replaceAll("[\\\\W]|_","").toLowerCase();
        int start=0;
        int end=s.length()-1;
        System.out.println(s);
        for (int i=0;i<s.length()/2;i++){
            if(s.charAt(start)==s.charAt(end--)){
                return true;
            }
        }
        return false;
    }

}
