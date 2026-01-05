package com.LeetCode.DynamicProgramming;

import java.util.Arrays;

public class NoOfWays {
    int mod = (int) (1e9 + 7);
    int[][] t;
     String [] states = {
            "RYG","RGY","RYR","RGR","YRG","YGR","YGY","YRY","GRY","GRG","GYG"
    };
    public   int noOfWays(int n){
        t = new int[n][12];
        for (int[] arr : t){
            Arrays.fill(arr , -1);
        }
        int result = 0;
        for (int i = 0;i<12;i++){
            result = (result + solve(n - 1,i) ) % mod;
        }
        return result;
    }

    private  int solve(int n, int prev) {
        if (n == 0){
            return 1;
        }
        if (t[n][prev] != -1) return t[n][prev];
        int result = 0;
        String last = states[prev];
        for (int curr = 0;curr<12;curr++){
            if (curr == prev) continue;
            String currPat = states[curr];
            boolean conflict = false;
            for(int i = 0;i<3;i++){
                if (currPat.charAt(i) == last.charAt(i)) {
                    conflict = true;
                    break;
                }
            }
            if (!conflict){
                result = (result + solve(n - 1,curr)) % mod;
            }
        }
        return t[n][prev] = result;
    }

    public static void main(String[] args) {
//        System.out.println(noOfWays(1));
    }
}
