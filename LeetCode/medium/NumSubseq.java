package com.LeetCode.medium;

import java.util.Arrays;
import java.util.Map;

public class NumSubseq {
    public int numSubseq(int[] nums,int target){
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        int[] power = new int[nums.length];
        power[0]=1;
        for(int i = 1;i<nums.length;i++){
            power[i] = (power[i - 1] * 2) % MOD;
        }
        while (left <= right ){
            if(nums[left] + nums[right] <= target){
                count = (count + power[right - left])%MOD;
                left++;
            }else {
                right--;
            }
        }
        return count;
    }
    private  static int floor(int[] nums,int target){

        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end-start) /2;
            if(target == mid){
                return mid;
            }
            else if(target > nums[mid]){
                start = mid + 1;
            }
            else {
                end = mid -1 ;
            }
        }
        return start;
    }
}
