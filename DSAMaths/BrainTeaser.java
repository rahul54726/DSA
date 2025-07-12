package com.DSAMaths;

import java.util.Arrays;

public class bulbswitch {
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
    public static int addDigits(int num) {
        if(num/10==0) return num;
        while (num >= 10){
            num=helper(num);
        }
        return num;
    }
    private static int helper(int num){
        int ans=0;
        while (num!=0){
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    public static void main(String[] args) {
//        int num=0;
        System.out.println(canWinNim(43));
    }
}
