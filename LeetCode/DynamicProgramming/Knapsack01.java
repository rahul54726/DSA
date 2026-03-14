package com.LeetCode.DynamicProgramming;

import java.util.Arrays;

public class Knapsack01 {
    int  n;
    int[][] dp;
    public   int maxProfit(int[] w ,int[] val, int wt){
        this.n = w.length;
        this.dp = new int[n][wt];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return solve(n - 1, w, val, wt);
    }
    private  int solve(int i , int[]w , int[] val, int wt){
         if(wt == 0) return 0;
         if(i == 0){
             if(wt >= w[0]) return val[0];
             else  return Integer.MIN_VALUE;
         }
         if(dp[i][wt] != -1) return dp[i][wt];
         int notTake = solve( i - 1 , w, val , wt);
         int take = Integer.MIN_VALUE;
         if(wt >= w[i]) take = val[i] + solve(i - 1,w, val, wt - w[i] );
         return dp[i][wt] = Math.max(take, notTake);
    }
}
