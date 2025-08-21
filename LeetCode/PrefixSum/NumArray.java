package com.LeetCode.PrefixSum;

public class NumArray {
    private int[] prifixSum;
    public NumArray(int[] nums) {
        for (int i = 1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        this.prifixSum = nums;
    }

    public int sumRange(int left, int right) {
        return left == 0 ? prifixSum[right]: prifixSum[right] - prifixSum[left-1];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(2,5));
    }
}
