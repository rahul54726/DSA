package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestSubarrays {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] setBit = new int[32];
        Arrays.fill(setBit ,-1);
        for (int i = n-1;i>=0;i--){
            int endIndex = i;
            for (int j = 0;j<32;j++){
                if((nums[i] & (1 << j)) != 0){
                    setBit[j] = i;
                }
                if(setBit[j] != -1) {
                    endIndex = Math.max(endIndex,setBit[j]);
                }
            }
            result[i] = endIndex -i + 1;
        }
        return result;
    }
}
