package com.LeetCode.medium;

import java.util.Arrays;

public class FirstLastPosition {
    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        //check for first index if target first
        ans[0]= search(nums,target,true);
        if (ans[0]!=-1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }
    //this function will return the index value of target
    static int search(int[] nums,int target,boolean findStart){
        int ans=-1;
        int start=0;
        int end=nums.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (nums[mid]>target) {
                end=mid-1;
            }
            else if(nums[mid]<target) {
                start = mid + 1;
            }
            else {
                //potential ans has been found
                ans=mid;
                if(findStart){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums= {5,7,7,8,8,10};
       int[] arr =searchRange(nums,8);
        System.out.println(Arrays.toString(arr));
    }
}
