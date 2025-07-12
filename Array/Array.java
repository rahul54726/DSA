package com.Arrays;// package com.Arrays;
import java.util.*;
public class Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mix=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while (i<m && j<n){
            if (nums1[i]<nums2[j]){
                mix[k]=nums1[i];
                i++;
            }
            else {
                mix[k]=nums2[j];
                j++;
            }
            k++;
        }
        while (i<m){
            mix[k]=nums1[i];
            i++;
            k++;
        }
        while (j<n){
            mix[k]=nums2[j];
            j++;
            k++;
        }
        for (int num:mix){
            System.out.print(num+" ");
        }
    }
    public  static List<List<Integer>> subArray(int[] nums){
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        for(int start=0;start<n;start++){
            List<Integer> currentSubArray=new ArrayList<>();
            for(int end=start;end<n;end++){
            currentSubArray.add(nums[end]);
            result.add(new ArrayList<>(currentSubArray));
            }
        }
        return result;
    }
    public static int[] applyOperations(int[] nums) {
        int n=nums.length;
        for (int i=0; i<n-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i]=2*nums[i];
                nums[i+1]=0;
                i++;
            }
        }
//        int[] copy=new int[n];
        int count=0;
        for (int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[count++]=nums[i];
            }
        }
        for(int i=count;i<n;i++){
            nums[i]=0;
        }
        return nums;
    }
//    public static int smallestDivisor(int[] nums, int threshold) {
//        if(threshold==1) {
//            return 1;
//        }
//        int[] arr=new int[nums.length];
//        for(int i=0;i<nums.length;i++){
//            arr[i]=findDivisorsum(nums,nums[i]);
//        }
//        System.out.println(Arrays.toString(arr));
//
//    }
    private static int findDivisorsum(int[] nums , int num){
        int sum = 0;
        for(int n:nums){
           if(n%num == 0){
               sum+=n/num;
           }
           else sum+=n/num+1;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums={1,2,5,9};
        System.out.println(findDivisorsum(nums,6));
//        System.out.println(smallestDivisor(nums,6));

    }
}
