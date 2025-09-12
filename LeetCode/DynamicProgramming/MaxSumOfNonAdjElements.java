package com.LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MaxSumOfNonAdjElements {
    public static String sortVowels(String s) {
        int[] arr = new int[10];
        String vowels = "AEIOUaeiou";
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(s.charAt(i) == 'A') arr[0]++;
            if(s.charAt(i) == 'E') arr[1]++;
            if(s.charAt(i) == 'I') arr[2]++;
            if(s.charAt(i) == 'O') arr[3]++;
            if(s.charAt(i) == 'U') arr[4]++;
            if(s.charAt(i) == 'a') arr[5]++;
            if(s.charAt(i) == 'e') arr[6]++;
            if(s.charAt(i) == 'i') arr[7]++;
            if(s.charAt(i) == 'o') arr[8]++;
            if(s.charAt(i) == 'u') arr[9]++;
            if ("AEIOUaeiou".indexOf(c) != -1) {
                list.add(i);
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        for(int ptr : list){
            while( i < arr.length && arr[i] == 0 ) i++;
            sb.setCharAt(ptr,vowels.charAt(i));
            arr[i]--;

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
    }
}
