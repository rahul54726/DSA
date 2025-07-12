package com.LeetCode.TWOPOINTER;

import java.util.HashMap;

public class SortColors {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count0 = map.getOrDefault(0,0);
        int count1=map.getOrDefault(1,0);
        int count2=map.getOrDefault(2,0);
        for (int i=0;i<count0;i++){
            nums[i]=0;
        }
        for (int i=count0;i<count0+count1;i++){
            nums[i]=1;
        }
        for (int i=count0+count1;i<count0+count1+count2;i++){
            nums[i]=2;
        }

    }
}
