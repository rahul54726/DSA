package com.LeetCode.stackandQueue;

import java.util.Stack;

public class SumOfSubArrayMax {
    public static int sumOfSubArrayMax(int[] nums){
        int [] NSE  = nextGEE(nums);
        int[] PSE = prevGreaterEqualElement(nums);
        long total = 0;
        int mod = (int) (1e9+7);
        for(int i = 0;i<nums.length;i++){
            long left = i - PSE[i];
            long right = NSE[i] - i;
            long numSubarrays = left * right;
            long contribution =numSubarrays * nums[i];
            total = (total + contribution) % mod;
        }
        return (int) total;
    }
    private static int[] nextGEE(int[] nums){
        int[] NGE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }
            NGE[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(nums[i]);
        }
        return NGE;
    }
    private static int[] prevGreaterEqualElement(int[] nums){
        int[] PGE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < nums.length;i++){
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] <= num){
                stack.pop();
            }
            PGE[i]= stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        return PGE;
    }
}
