package com.LeetCode.days75;
import java.util.*;
public class MinMaxDiffrence {
    public int minMaxDifference(int num) {
            return maximize(num) - minimize(num);
    }
    private static int minimize(int num){
        String str = String.valueOf(num);
        char ch = str.charAt(0);
//        System.out.println(ch);
        char[] chars = str.toCharArray();
        String newStr = "";
        for(char c :chars){
            if(c == ch) c='0';
            newStr +=c;
        }
        return Integer.parseInt(newStr);
    }private static int maximize(int num){
        String str = String.valueOf(num);
        char ch = str.charAt(0);
//        System.out.println(ch);
        char[] chars = str.toCharArray();
        String newStr = "";
        for(char c :chars){
            if(c == ch) c='9';
            newStr +=c;
        }
        return Integer.parseInt(newStr);
    }
//    private int maximize(int num){
//        int newNum = 0;
//    }


    public static void main(String[] args) {
//        System.out.println(reverseNum(25));
        System.out.println(minimize(90));
        System.out.println(maximize(90));
    }
}
