package com.LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LDS {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int max = 1;
        int lastIdx = 0;
        for (int i = 0;i<n;i++){
            hash[i] = i;
            for (int prev = 0;prev < i;prev++){
                if(nums[i] % nums[prev] == 0 &&  dp[i] < 1 +  dp[prev]){
                    dp[i] = 1 +  dp[prev];
                    hash[i] = prev;
                }
            }
            if (dp[i] > max){
                max = dp[i];
                lastIdx = i;
            }
        }
        ans.add(nums[lastIdx]);
        while (hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx];
            ans.add(nums[lastIdx]);
        }
        return ans.reversed();
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{3,5,10,20,30}));
    }

}
