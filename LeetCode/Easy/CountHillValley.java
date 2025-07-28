package com.LeetCode.Easy;

import java.util.*;

public class CountHillValley {
    public static int countHillValley(int[] nums){
        List<Integer>filtered = new ArrayList<>();
        int hills = 0;
        filtered.add(nums[0]);
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                filtered.add(nums[i]);
            }

        }
        for(int i = 1;i<filtered.size() -1 ;i++){
           if((filtered.get(i) > filtered.get(i-1) && filtered.get(i) > filtered.get(i+1)) || (filtered.get(i) < filtered.get(i-1) && filtered.get(i) < filtered.get(i+1))){
               hills++;
            }
        }
        return hills ;
    }
    public static void main (String[] args){
        System.out.println(countHillValley(new int[]{6,6,5,5,4,1}));
    }
}
