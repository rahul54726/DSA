package com.LeetCode.medium;


import java.util.*;

public class PartitionArray {
    public static int partitionArray(int[] nums,int k){
        if(nums == null || nums.length == 0){
            return 0;
        }
//        List<List<Integer>> outer = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 1;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
            if((max - min)<=k){
                count++;
                min=max;
            }
        }
        return count;
    }
    public static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b) -> b -a);
        int left = 0;
        int maxLength = 0;
        for(int right = 0;right< nums.length;right++){
            maxHeap.add(nums[right]);
            minHeap.add(nums[right]);
            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() - minHeap.peek() >limit){
                maxHeap.remove(nums[left]);
                minHeap.remove(nums[left]);
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }
    return maxLength;
//        Deque<Integer> minDeque = new LinkedList<>(); // For minimum elements
//        Deque<Integer> maxDeque = new LinkedList<>(); // For maximum elements
//        int left = 0, maxLength = 0;
//
//        for (int right = 0; right < nums.length; right++) {
//            // Maintain decreasing order in maxDeque
//            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
//                maxDeque.pollLast();
//            }
//            maxDeque.offerLast(right);
//
//            // Maintain increasing order in minDeque
//            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
//                minDeque.pollLast();
//            }
//            minDeque.offerLast(right);
//
//            // Check if the window is invalid
//            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
//                // Shrink the window from the left
//                if (maxDeque.peekFirst() == left) {
//                    maxDeque.pollFirst();
//                }
//                if (minDeque.peekFirst() == left) {
//                    minDeque.pollFirst();
//                }
//                left++;
//            }
//
//            // Calculate the maximum length of the valid window
//            maxLength = Math.max(maxLength, right - left + 1);
//        }
//
//        return maxLength;
    }
}
