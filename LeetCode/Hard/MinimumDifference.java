package com.LeetCode.Hard;

import java.util.*;

public class MinimumDifference {
    public static long minimumDifference(int[] nums) {
        int n = nums.length / 3 ;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long[] leftMin = new long[2*n];

        long leftSum = 0;
        for(int i = 0;i<2*n;i++){
            maxHeap.offer(nums[i]);
            leftSum+=nums[i];
            if(maxHeap.size() >n){
                leftSum -= maxHeap.poll();
            }
            if(maxHeap.size() == n) leftMin[i]=leftSum;
        }
        System.out.println(maxHeap);
        long[] rightMax = new long[2*n + 1];
        long rightSum = 0;
        for(int i = 3*n-1;i>=n;i--){
            minHeap.offer(nums[i]);
            rightSum+=nums[i];
            if(minHeap.size() > n){
                rightSum-=minHeap.poll();
            }
            if (minHeap.size() == n){
                rightMax[i]=rightSum;
            }
        }
        System.out.println(minHeap);
        long result = Long.MIN_VALUE;
        for(int i = n-1;i<2*n;i++){
            result = Math.min(result,leftMin[i]-rightMax[i+1]);
        }
        return result;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap.add(1);
        maxHeap.add(5);
//        System.out.println(maxHeap);
        System.out.println(minimumDifference(new int[]{7,9,5,8,1,3}));
    }
}
