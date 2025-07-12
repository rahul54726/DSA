package com.CollectionFrameWorks.HashMaps;

import java.util.HashSet;

public class HashSets {
    public static void main(String[] args) {
        

    }
    public static int[] intersection(int[] nums1,int[] nums2){
        HashSet<Integer> set1=new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        HashSet<Integer> intersection=new HashSet<>();
        for(int num:nums2){
            if(set1.contains(num)){
                intersection.add(num);
            }
        }
        int[] result=new int[intersection.size()];
        int index=0;
        for(int num:intersection){
            result[index++]=num;
        }
        return result;
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longestStreak=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int currentNum=num;
                int currentStreak=1;
                while (set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
