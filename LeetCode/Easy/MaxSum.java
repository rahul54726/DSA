package com.LeetCode.Easy;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class MaxSum {
    public static int maxSum(int[] nums){
//        HashSet<Integer> set = new HashSet<>();
//        int max = 0;
//        int temp = 0;
//        int left = 0;
//        int right = 0;
//        while (right<nums.length){
//            int num = nums[right];
//            while (set.contains(num)){
//                set.remove(nums[left]);
//                temp -= nums[left++];
//            }
//            set.add(num);
//            temp+=num;
//            max = Math.max(max,temp);
//            right++;
//        }
//        return max;
        int max = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        if(max <= 0){
            return max;
        }
        Set<Integer> seen = new HashSet<>();
        int total = 0;
        for(int num:nums){
            if(num>0 && seen.add(num)) total+=num;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{-20,20}));
    }
}
