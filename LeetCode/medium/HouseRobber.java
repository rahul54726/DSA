package com.LeetCode.medium;

public class HouseRobber {
    public static int rob(int[] nums) {
        int index2 = 0;
        int index1 = 0;
        for(int num : nums){
            int current = Math.max(index1,index2+num);
            index2 = index1;
            index1 = current;
        }
        return index1;
    }
}
