package com.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/frog-jump/description/
public class FrogJump {
    public static int minEnergy(int[] stairs) {
        int n = stairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return backtrack(n-1,stairs,dp);
    }

    private static int backtrack(int i, int[] stairs, int[] dp) {
        if (i == 0) return 0;
        if (dp[i] != -1) return dp[i];

        int oneStep = backtrack(i-1,stairs,dp) + Math.abs(stairs[i] - stairs[i-1]);
        int twoStep = Integer.MAX_VALUE;
        if(i > 1) {
             twoStep = backtrack(i-2,stairs,dp)+Math.abs(stairs[i] - stairs[i-2]);
        }
        return dp[i] = Math.min(oneStep,twoStep);
    }

    public static void main(String[] args) {
        System.out.println(minEnergy(new int[]{30, 10, 60, 10, 60, 50}));
    }
}
