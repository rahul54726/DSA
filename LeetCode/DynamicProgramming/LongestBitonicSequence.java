package com.LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.OptionalInt;

public class LongestBitonicSequence {
    public static int LBS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0;i<n;i++){
            for (int prev = 0; prev < i; prev++) {
                if(nums[i] > nums[prev] ){
                    dp[i] = Math.max(dp[i] , 1 +  dp[prev]);
                }

            }
        }

        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        for (int i = n-1;i>=0;i--){
            for (int prev = n-1; prev  > i; prev--) {
                if(nums[i] > nums[prev] ){
                    dp2[i] = Math.max(dp2[i] , 1 +  dp2[prev]);
                }

            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0;i<n;i++){
            ans = Math.max(ans , (dp[i] + dp2[i]-1));
        }
return 0;
    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0;i<n;i++){
            dp[i] = 1;
            for(int prev = 0;prev < i;prev++){
                if(nums[i] > nums[prev]){
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }

        }
        int max = Arrays.stream(dp).max().getAsInt();
        int count = Math.toIntExact(Arrays.stream(dp).filter(x -> x == max).count());
        return count;
    }
    static boolean[] doors = new boolean[101];
    public  static  void openDoors(){
        for (int i = 1;i<=100;i++){
            key(i);
        }

        for (int i = 1; i <= 100 ; i++) {
            if (doors[i]) System.out.println(i + "th door open");
        }
    }
    private static  void key(int n){
        for (int i = n;i<=100;i+=n){
            if( i % n == 0) {
                doors[i] = !doors[i];
            }
        }
    }

    public static void main(String[] args) {
        openDoors();
    }
}
