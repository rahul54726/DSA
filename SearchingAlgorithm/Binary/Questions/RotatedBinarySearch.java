package com.SearchingAlgorithm.Binary.Questions;

public class RotatedBinarySearch {
    public int search(int[] nums, int target) {
        int pivot = pivot(nums);
        if(pivot == -1){
            // normal binary Search
            return binarysearch(nums,target,0,nums.length - 1);
        }
        // pivot exist
        if(nums[pivot] == target) return pivot;
        if(target > nums[0]){
            return binarysearch(nums,target,0,pivot);
        }
        return binarysearch(nums,target,pivot,nums.length - 1);
    }

    private int binarysearch(int[] nums, int target, int s, int e) {
        if (s > e){
            return -1;
        }
        int m = s + (e - s) / 2;
        if(nums[m] == target) return m;
        if(nums[m] > target) return binarysearch(nums,target,s , m - 1);
        else return binarysearch(nums,target,m + 1,e);
    }

    private int pivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid  = start + (end - start)/2;
            if (mid < end && nums[mid] > nums[mid+1]) return mid;
            else if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            else if(nums[mid] <= nums[start]) end = mid - 1;
            else if (nums[mid] > nums[start]) start = mid + 1;
        }
        return -1;
    }
}
