package com.LeetCode.PrefixSum;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int num:nums){
            total+= num;
        }
        int leftSum = 0;
        for(int i = 0;i<nums.length;i++){
            int rightSum = total - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: prefix products
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{2,1,-1}));
    }
}
