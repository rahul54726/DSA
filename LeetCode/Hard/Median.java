package com.LeetCode.Hard;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int k=0;
        int[] mix=new int[nums1.length+nums2.length];
        while (i<nums1.length && j<nums2.length){
            if (nums1[i]<nums2[j]){
                mix[k++]=nums1[i++];
            }
            else {
                mix[k++]=nums2[j++];
            }
        }
        while (i<nums1.length){
            mix[k++]=nums1[i];
        }
        while (j<nums2.length){
            mix[k++]=nums2[j];
        }
        if ((mix.length&1)==1){
            return (double) mix[(mix.length-1)/2];
        }
        else {
            return (double) (mix[(mix.length - 1) / 2] + mix[(mix.length - 1) / 2 + 1]) /2;
        }
    }
}
