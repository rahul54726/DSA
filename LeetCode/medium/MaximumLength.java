package com.LeetCode.medium;

public class MaximumLength {
    public int maximumLength(int[] nums, int k) {
        int[][] memo = new int[k][k];
        int maxLen = 0;
        for(int num:nums){
            int currentMod = num % k;
            for(int prevMod = 0;prevMod < k;prevMod++){
                memo[prevMod][currentMod] = memo[currentMod][prevMod]+1;
                maxLen = Math.max(maxLen,memo[prevMod][currentMod]);
            }
        }
        return maxLen;
    }
}
