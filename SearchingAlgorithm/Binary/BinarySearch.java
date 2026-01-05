package com.SearchingAlgorithm.Binary;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int[] nums = {9,8,7,6,5,4,3,2,1};
        System.out.println(orderAgnosticBS(nums,2));
//
//        Display(arr);
//        System.out.println();
//        System.out.println(Search(arr,2));

    }
    static void Display(int[] arr){
        System.out.print(Arrays.toString(arr));
    }
    static int Search(int[] arr,int target){
        if(arr.length==0) return -1;
        int start=0;
        int end=arr.length-1;
        while (start<=end){
//            find mid element
            int mid=start+(end-start)/2;
            if(arr[mid]>target){
                end=mid-1;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else return mid;

        }
        return -1;
    }
    static int orderAgnosticBS(int[] arr,int target){
        if(arr.length==0) return -1;
        int start=0;
        int end=arr.length-1;
        boolean isAsc = arr[0] < arr[arr.length-1];
        while (start<=end){
//            find mid element
            int mid=start+(end-start)/2;
            if (arr[mid] == target) return mid;
            if (isAsc){
                if(arr[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else {
                if (arr[mid] > target) start = mid + 1;
                else end = mid - 1;
            }

        }
        return -1;
    }
    private static int infiniteSortedArray(int[] nums,int target){
        int start = 0;
        int end = 1;
        while (target > nums[end]){
            int newStart = end + 1;
            end = end + (end - start) * 2;
            start = newStart;
        }
        return binarySearchRange(nums,target,start,end);
    }

    private static int binarySearchRange(int[] nums, int target, int start, int end) {
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target){
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
            else return mid;
        }
        return -1;
    }
}
