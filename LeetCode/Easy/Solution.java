package com.LeetCode.Easy;

public class Solution {
    public static int removeElement(int[] nums) {

        int k=0;
        for(int i=0;i<nums.length-1;i++){

            if(nums[i]==nums[i+1]) {
                nums[k]=nums[i];
                k++;
            }

        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(removeElement(nums));
    }
}
