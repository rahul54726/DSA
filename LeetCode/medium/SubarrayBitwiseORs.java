package com.LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class SubarrayBitwiseORs {
    public static  int subarrayBitwiseORs(int[] nums){
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int num:nums){
            Set<Integer> current = new HashSet<>();
            current.add(num);
            for(int val : prev){
                current.add(val|num);
            }
            prev = current;
            result.addAll(current);
        }
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(subarrayBitwiseORs(new int[]{1,1,2}));
    }
}
