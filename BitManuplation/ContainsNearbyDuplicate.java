package com.BitManuplation;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0;i< nums.length;i++){
            int forwardCheck = Math.min(i + k, nums.length-1);
            for(int j = i+1;j <= forwardCheck ;j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
