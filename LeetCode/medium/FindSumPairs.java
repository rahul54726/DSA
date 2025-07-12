package com.LeetCode.medium;

import java.util.HashMap;

public class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer,Integer> fmap;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 =nums1;
        this.nums2 =nums2;
        this.fmap = new HashMap<>();
        for(int num:nums2){
            fmap.put(num,fmap.getOrDefault(num,0)+1);
        }
    }
    public void add(int index, int val) {
        int temp = nums2[index] ;
        fmap.put(temp,fmap.get(temp)-1);
        if(fmap.get(temp) == 0){
            fmap.remove(temp);
        }
        nums2[index]+= val;
        int newVal = nums2[index];
        fmap.put(newVal,fmap.getOrDefault(newVal,0)+1);
    }

    public int count(int tot) {
        int count = 0;
        for(int num:nums1){
            count+=fmap.getOrDefault((tot-num),0);
        }
        return count;
    }
}
