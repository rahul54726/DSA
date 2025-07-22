package com.LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarray {
    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> fmap = new HashSet<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (right < nums.length){
            if(!fmap.contains(nums[right])){
                fmap.add(nums[right]);
                sum+=nums[right];
                max = Math.max(max,sum);
                right++;
            }
            else {
                fmap.remove(nums[left]);
                sum-=nums[left++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[] {4,2,4,5,6}));
    }
}
