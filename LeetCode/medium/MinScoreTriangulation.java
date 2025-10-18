package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class MinScoreTriangulation {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {
                    int currentScore = values[i] * values[k] * values[j] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], currentScore);
                }
            }
        }
        return dp[0][n - 1];
    }
    public static int triangularSum(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return (nums[0]+nums[1])%10;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n-1;i++){
            list.add((nums[i]+nums[i+1])%10);
        }
        while(list.size() != 1){
            for(int i = 0;i<list.size()-1;i++){
                list.set(i,(list.get(i)+list.get(i+1))%10);
            }
            list.remove(list.size()-1);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{2,3}));
    }
}
