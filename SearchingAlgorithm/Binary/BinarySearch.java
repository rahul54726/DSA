package com.SearchingAlgorithm.Binary;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr={2,3,5,9,14,16,18};
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

}
