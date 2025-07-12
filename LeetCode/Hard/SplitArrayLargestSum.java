package com.LeetCode.Hard;

public class SplitArrayLargestSum {
    static int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;
        for (int j : nums) {
            start = Math.max(start, j);  // int the end of loop this contain the max item from the item
            end += j;

        }
            // binary search
        while (start<end){
            //try for mid as the potential ans
            int mid=start+(end-start)/2;
            //calculate how many pieces we acn divide this max sum
            int sum=0;
            int pices=1;
            for(int num: nums){
                if (sum+num>mid){
                    //you cannot add this in new subarray make new one
                    //say you add this num in subarray then sum = num
                    sum=num;
                    pices++;
                }
                else {
                    sum += num;
                }
            }
            if (pices>k){
                start=mid+1;
            }
            else {
                end=mid;
            }
        }
            return end;
    }

    public static void main(String[] args) {

    }
}
