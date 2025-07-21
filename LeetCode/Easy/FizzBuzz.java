package com.LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result  = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(  i%3 == 0 && i%5 != 0){
                result.add("Fizz");
            }
            else if(i >= 5 && i % 5 == 0  && i % 3 != 0){
                result.add("Buzz");
            }
            else if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            }
            else {
                result.add(String.valueOf(i));
            }
        }
       return result;
    }
    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int freq = 1;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                freq++;
            }
            else {
                freq = 1;
            }
            if(freq <= 2){
                sb.append(s.charAt(i));
            }
        }
        return s.isEmpty() ? "" : s.charAt(0) + sb.toString();
    }
    public static void main(String[] args) {
//        System.out.println(fizzBuzz(30));
        System.out.println(makeFancyString(" "));
    }
}
