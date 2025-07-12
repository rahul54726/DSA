package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxFreeTime {
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        ArrayList<Integer> freeTime = new ArrayList<>();
       freeTime.add(startTime[0]);
        for(int i = 1 ;i < startTime.length;i++){
                int free = startTime[i] - endTime[i-1];
                freeTime.add(free);
        }
       freeTime.add(eventTime - endTime[endTime.length -1]);
        System.out.println(freeTime);
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (right < freeTime.size()){
            currentSum += freeTime.get(right);
            if( left < freeTime.size() && right - left +1 > k+1){
                while (left < freeTime.size() && right - left +1 > k +1){
                    currentSum -= freeTime.get(left);
                    left++;
                }
            }
            max = Math.max(max,currentSum);
            right++;
        }

        return max;
    }
    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        ArrayList<Integer> freeTime = new ArrayList<>();
        if(startTime[0]!=0) freeTime.add(startTime[0]);
        for(int i = 1 ;i < startTime.length;i++){
            int free = startTime[i] - endTime[i-1];
            freeTime.add(free);
        }
        if(eventTime - endTime[endTime.length -1] != 0) freeTime.add(eventTime - endTime[endTime.length -1]);
        int max = 0;
        for(int i = 0;i<startTime.length;i++){
            int time = endTime[i] - startTime[i];
            for(int num:freeTime){
                if(num == time){
                    max = Math.max(max,max+time);
                }
            }
        }
        return max;
    }
        public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

        private void backTrack(int[] nums, int idx, List<Integer> inner, List<List<Integer>> result) {
        if (inner.size() >= 2) {
            result.add(new ArrayList<>(inner)); // Make a copy
        }

        Set<Integer> used = new HashSet<>();

        for (int i = idx; i < nums.length; i++) {
            if ((inner.isEmpty() || nums[i] >= inner.get(inner.size() - 1)) && !used.contains(nums[i])) {
                used.add(nums[i]);
                inner.add(nums[i]);
                backTrack(nums, i + 1, inner, result);
                inner.remove(inner.size() - 1); // Backtrack
            }
        }
    }


    public static void main(String[] args) {
        System.out.println( maxFreeTime(10,1,new int[]{0,3,7,9},new int[]{1,4,8,10}));
    }
}
