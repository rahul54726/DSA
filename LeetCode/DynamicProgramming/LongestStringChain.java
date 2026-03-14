package com.LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStringChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
    public static int longestStringChain(String[] strs){
        Arrays.sort(strs,Comparator.comparing(String::length));
        int n = strs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        BiPredicate<String,String> predicate = (s1,s2) -> {
            if(s1.length() != s2.length() + 1) return false;
            int i = 0;
            int j = 0;
            while (i < s1.length() && j < s2.length()){
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                }
                i++;
            }
            return j == s2.length();
        };
        int max = 1;
        for (int i = 0;i < n;i++){
            for (int prev = 0;prev < i ;prev++){
                if(predicate.test(strs[i], strs[prev]) ){
                    dp[i] = Math.max(dp[prev] + 1, dp[i]);
                }

            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
