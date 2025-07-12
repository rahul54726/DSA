package com.LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindKDistantIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int j = 0;j<nums.length;j++){
            if(nums[j] == key) {
                int start = Math.max(j - k,0);
                int end = Math.min(j + k,nums.length-1);
                if(result.getLast() >= start && !result.isEmpty()) {
                    start = result.getLast() + 1;
                }

                for(int i = start;i<=end;i++){
                    result.add(i);
                }
            }
        }
        result.removeFirst();
        return result;
    }
}
