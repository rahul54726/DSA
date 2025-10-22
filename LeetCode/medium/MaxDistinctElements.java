package com.LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxDistinctElements {
    public static int maxDistinctElements(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            for (int i = -k;i<=k;i++){
                if (!set.contains(num+i)){
                    set.add(num+i);
                    break;
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(maxDistinctElements(new int[]{4,4,4,4},1));
    }
}
