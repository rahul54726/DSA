package com.LeetCode.medium;

import java.util.HashMap;

public class NextBeautifulNumber {

    public static int nextBeautifulNumber(int n){
        for (int i = n + 1;i<1224444;i++){
            if(isBalanced(i)) return i;
        }
        return -1;
    }
    private static boolean isBalanced(int n){
        int[] fmap = new int[10];
        int temp = n;
        while (temp > 0){
            int rem = temp % 10;
            temp /=10;
            fmap[rem]++;
        }
        temp = n;
        while (temp > 0){
            int rem = temp % 10;
            temp/=10;
            if(fmap[rem] != rem) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(1));
    }
}
