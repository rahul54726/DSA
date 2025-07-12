package com.SearchingAlgorithm.Binary;

import java.util.Arrays;
import java.util.Scanner;

public class CeilingAndFloor {
    // return the index of smallest number >=target
    static int ceiling(int[] arr,int target){
        if(target>arr[arr.length-1]){
            return -1;
        }
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]==target) return mid;
            else if (arr[mid]>target) {
                end=mid-1;
            }
            else start=mid+1;
        }
        return start;
    }
    static int floor(int[] arr,int target){
        if(target<arr[0]){
            return -1;
        }
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]==target) return mid;
            else if (arr[mid]>target) {
                end=mid-1;
            }
            else start=mid+1;
        }
        return end;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the size of arr : ");
        int n=in.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the Array : ");
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        System.out.println("The Array is : "+Arrays.toString(arr));
        System.out.print("Enter the target element : ");
        int target=in.nextInt();
        int ansceiling =ceiling(arr,target);
        System.out.println("The Index of Ceiling  of "+target +" is : "+ansceiling);
        int ansfloor =floor(arr,target);
        System.out.println("The Index of Floor of "+target +" is : "+ansfloor);
    }
}
