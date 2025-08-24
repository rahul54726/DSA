package com.LeetCode.priorityQueue;

import java.util.*;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num:stones){
            priorityQueue.add(num);
        }
        while (priorityQueue.size() > 1){
            int max = priorityQueue.poll();
            int secMax = priorityQueue.poll();
            if(max == secMax) continue;
            else {

             int result = max- secMax;
                priorityQueue.offer(result);
            }
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
    }
    public static int longestSubarray(int[] nums) {
        int right = 0,left = 0;
        int count = 0;
        int maxWindow = 0;
        while (right < nums.length){
            if(nums[right] == 0) count++;
            while (count > 1 ){
                if (nums[left] == 0) count--;
                left++;
            }
            maxWindow = Math.max(maxWindow,right - left + 1);
            right++;
        }
        return maxWindow-1;
    }
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }
}
class KthLargest {
    private  final  int k;
    PriorityQueue<Integer> priorityQueue;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>();
        for (int num:nums){
            priorityQueue.add(num);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
    }

    public int add(int val) {
        this.priorityQueue.add(val);
        if (priorityQueue.size() > this.k) priorityQueue.poll();
        return priorityQueue.peek();
    }
}
