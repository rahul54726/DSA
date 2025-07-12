package com.LeetCode.medium;

public class PeakIndex {
    public static void main(String[] args) {
    int[] arr={1, 2, 3, 5, 6, 4, 3, 2};
        System.out.println(arr[peakIndexInMountainArray(arr)]);
    }
    static int peakIndexInMountainArray(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while(s<e){
            int m=s+(e-s)/2;
            if(arr[m]>arr[m+1]) e=m;
            else s=m+1;
        }
        return e;
    }
}
