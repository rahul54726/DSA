package com.LeetCode.Greedy;

import java.util.*;

public class Knapsack {
    public static double fractionalKnapsack(int W, int[] weight, int[] value) {
        int n = weight.length;


        double[][] arr = new double[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = (double) value[i] / weight[i]; // ratio
            arr[i][1] = weight[i];
            arr[i][2] = value[i];
        }


        Arrays.sort(arr, (a, b) -> Double.compare(b[0], a[0]));

        double maxValue = 0.0;

        for (int i = 0; i < n && W > 0; i++) {
            double wt = arr[i][1];
            double val = arr[i][2];
            double ratio = arr[i][0];

            if (wt <= W) {
                maxValue += val;
                W -= wt;
            } else {
                maxValue += ratio * W;
                W = 0;
            }
        }

        return maxValue;
    }
//    public int knapsack01(int W, int[] weight, int[] value) {
//        int n = weight.length;
//
//        // dp[j] = max value using capacity j (1D optimized DP)
//        int[] dp = new int[W + 1];
//
//        for (int i = 0; i < n; i++) {
//            // iterate backward to avoid overwriting needed states
//            for (int j = W; j >= weight[i]; j--) {
//                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
//            }
//        }
//
//        return dp[W];
//    }
public static int knapsack01(int W, int[] weight, int[] value) {
    int n = weight.length;
    int[][] k = new int[5][9];
    for (int i = 0;i<=n;i++){
        for (int w  =0;w<=W;w++ ){
            if (i == 0 || w ==0){
                k[i][w] = 0;
            } else if (weight[i] <= w) {
                k[i][w] = Math.max(value[i]+k[i-1][w-weight[i]],k[i-1][w]);
            }
            else {
                k[i][w] = k[i-1][w];
            }
        }
    }
    return k[n][W];
}
    public static void main(String[] args) {
        int W = 60;
//        int[] weights = {10, 20, 30};
        int[] values = {15, 45, 10, 30, 60, 25, 35, 50, 40, 55};
//        int[] values = {60, 100, 120};
        int[] weights = {2, 10, 1, 5, 20, 8, 7, 12, 9, 15};
        int n = weights.length;

        System.out.println(fractionalKnapsack(W, weights, values));
        // expected: 240.0
//        System.out.println(knapsack01(8,new int[]{0,1,2,5,6},new int[]{0,2,3,4,5}));
    }
}
