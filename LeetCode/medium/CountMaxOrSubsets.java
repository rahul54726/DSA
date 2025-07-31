package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class CountMaxOrSubsets {
    public static int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        // Step 1: Find the maximum OR value possible from all subsets
        for (int num : nums) {
            maxOr |= num;
        }

        int[] count = new int[1]; // Use array to pass by reference
        dfs(nums, 0, 0, maxOr, count);
        return count[0];
    }

    private static void dfs(int[] nums, int index, int currentOr, int targetOr, int[] count) {
        if (index == nums.length) {
            if (currentOr == targetOr) {
                count[0]++;
            }
            return;
        }

        // Include nums[index]
        dfs(nums, index + 1, currentOr | nums[index], targetOr, count);

        // Exclude nums[index]
        dfs(nums, index + 1, currentOr, targetOr, count);
    }

    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{3,2,1,5}));
    }
}
