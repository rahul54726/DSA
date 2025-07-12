package com.LeetCode.Easy;

import java.util.Arrays;

public class InfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        System.out.println(Arrays.toString(arr));
        System.out.println(findingRange(arr,18));
    }
    static int findingRange(int[] arr,int target){
        //first find the range
        //start with box of length 2
        int start=0;
        int end=1;
        //codition for the target to lie in the range
        while (arr[end]<target){
            int newStart=end+1;
            //double the size of box
            //end =previous end+sizeofbox*2
            end = end + (end-start+1)*2;
            start = newStart;
        }
        return Search(arr,target,start,end);
    }
    static int Search(int[] arr,int target,int start,int end){
        if(arr.length==0) return -1;
        while (start<=end){
//            find mid element
            int mid=start+(end-start)/2;
            if(arr[mid]>target){
                end=mid-1;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else {
                return mid;
            }

        }
        return -1;
    }
}
