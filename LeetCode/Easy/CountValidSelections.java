package com.LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountValidSelections {
        public static int countValidSelections(int[] nums) {
            int n = nums.length;
            int result = 0;
            int currSum = 0;
            int S = 0;

            for (int num : nums) {
                S += num;
            }

            for (int i = 0; i < n; i++) {
                currSum += nums[i];

                int left  = currSum;
                int right = S - left;

                if (nums[i] != 0)
                    continue;

                if (left == right)
                    result += 2;
                else if (Math.abs(left - right) == 1)
                    result++;
            }

            return result;
        }


    public static void main(String[] args) {
        System.out.println(countValidSelections(new int[]{16,13,10,0,0,0,10,6,7,8,7}));
    }
}
