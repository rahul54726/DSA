package com.LeetCode.medium;

public class RotatedArray {
    static int search(int[] nums, int target) {
        int pivot=findPivot(nums);

        if(pivot==-1){
          return   Search(nums,target,0,nums.length-1);
        }
        //if pivot is found you have found two ascending order arrays
        if (nums[pivot]==target) return pivot;
        if(nums[0]<=target){
            return Search(nums,target,0,pivot-1);
        }
        else {
            return Search(nums,target,pivot+1,nums.length-1);
        }

    }

    static int findPivot(int[] nums){
        int s=0;
        int e=nums.length-1;
        while (s<e){
            int m=s+(e-s)/2;
            if(m<e && nums[m]>nums[m+1]) {
                return m;
            }
            else if (m>s &&nums[m-1]>nums[m]) {
                return m - 1;
            }
            if(nums[s]>=nums[m]) {
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }
        return -1;
    }
    static int Search(int[] nums,int target,int start,int end){
        if(nums.length==0) return -1;
        while (start<=end){
//            find mid element
            int mid=start+(end-start)/2;
            if(nums[mid]>target){
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else return mid;

        }
        return -1;
    }
    static int countOfRotation(int[] arr){
        return findPivot(arr)+1;
    }

    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(search(arr,2));
        System.out.println(countOfRotation(arr));
    }
}
