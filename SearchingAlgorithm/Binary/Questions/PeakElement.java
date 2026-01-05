package com.SearchingAlgorithm.Binary.Questions;

public class PeakElement {
    public  static  int peak(int[] nums){
        int start = 0 , end = nums.length;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid + 1]) end = mid;
            else if(nums[mid] < nums[mid + 1]) start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(peak(new  int[]{1,2,3,5,6,4,3,2}));
    }
}
