package com.LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongHS {
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int maxLength = 0;
        for(int right = 0;right<nums.length;right++){
            while (nums[right] - nums[left] >1){
                left++;
            }
            if(nums[right] - nums[left]==1){
                maxLength = Math.max(maxLength,right - left +1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,1,1,1}));
    }
}
