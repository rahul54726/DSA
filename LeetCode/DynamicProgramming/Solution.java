package com.LeetCode.DynamicProgramming;

import java.util.Arrays;

class Solution {
    int[][][] dp;
    int m , n;
    int[] dj = {-1,0,1};
    public int maxChocolates(int[][] g) {
        // Your code goes here
        this.m = g.length;
        this.n = g[0].length;
        this.dp = new int[m][n][n];
        for(int[][] OA : dp ){
            for(int[] A : OA) Arrays.fill(A , -1);
        }
        return solve(0,0,n-1 , g);
    }
    private int solve(int i , int j1, int j2, int[][] g){
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) return Integer.MIN_VALUE;

        if(i == m - 1) {
            if(j1 == j2) return g[i][j1];
            else return g[i][j1] + g[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        for(int dj1 : dj){
            for(int dj2 : dj){
                int nj1 = j1 + dj1;
                int nj2 = j2 + dj2;
                if (nj1 >= 0 && nj1 < n && nj2 >= 0 && nj2 < n){
                    if(j1 == j2 ){
                        int val = g[i][j1] + solve(i + 1,nj1 , nj2 , g);
                        max = Math.max(val, max);
                    }else{
                        int val = g[i][j1] + g[i][j2] + solve(i + 1,nj1 , nj2 , g);
                        max = Math.max(val,max);
                    }
                }

            }
        }
        return dp[i][j1][j2] = max;
    }
}
