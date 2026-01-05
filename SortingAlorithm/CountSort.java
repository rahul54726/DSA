package com.SortingAlorithm;

import java.util.Arrays;

public class CountSort {
    public static void countSort(int[] nums){
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freqMap = new int[max+1];
        for (int num : nums) {
            freqMap[num]++;
        }
        int j = 0;
        for (int i = 0;i<freqMap.length;i++){
                while (freqMap[i] > 0){
                    nums[j++] = i;
                    freqMap[i]--;
                }
        }
        System.out.println(Arrays.toString(nums));;
    }

    public static void main(String[] args) {
        countSort(new int[]{3,4,1,3,2,5,8});
    }
}
