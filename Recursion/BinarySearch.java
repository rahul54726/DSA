package com.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={9,12,5,10,14,3,10};
        System.out.println(binarysearch(arr,10,0,arr.length-1));
//        swap(arr,1,2);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(pivotArray(arr,10)));
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
    public static int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small=new ArrayList<>();
//        ArrayList<Integer> equal=new ArrayList<>();

        ArrayList<Integer> large=new ArrayList<>();
        for(int num:nums){
            if(num<pivot){
                small.add(num);
            }
            else if(num==pivot) large.addFirst(num);
            else large.add(num);

        }
        int [] result=new int[nums.length];
        int index=0;
        for(int num : small){
            result[index++]=num;
        }
        for(int num:large){
            result[index++]=num;
        }

        return result;
    }
    private static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    private static int pivotPoint(int[] arr,int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(arr[mid]==target) return mid;
        if(arr[mid]>target) return pivotPoint(arr,target,start,mid-1);
        return pivotPoint(arr,target,mid+1,end);
    }
}
