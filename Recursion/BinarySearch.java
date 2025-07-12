package com.Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,55,66,78};
        System.out.println(binarysearch(arr,78,0,arr.length-1));
    }
    static int binarysearch(int[] arr,int target,int s,int e){
        if(s>e){
            return -1;
        }
        int mid=s+(e-s)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
          return   binarysearch(arr,target,s,mid-1);
        }

        return binarysearch(arr,target,mid+1,e);

    }
}
