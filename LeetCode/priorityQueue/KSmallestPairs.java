package com.LeetCode.priorityQueue;

import java.util.*;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] - b[0] );
        for (int i = 0;i<Math.min(nums1.length,k);i++){
            minHeap.offer(new int[]{nums1[i]+nums2[0] , i , 0});
        }
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int i = pair[1],j = pair[2];
            result.add(Arrays.asList(nums1[i],nums2[j]));
            if(j+1 < nums2.length){
                minHeap.offer(new int[]{nums1[i] + nums2[j+1],i ,j+1});
            }
        }
        return result;
    }
}
