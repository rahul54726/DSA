package com.LeetCode.priorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxScore {
    static Map<String,Long> memo;
    public static long maxScore(int[] nums1,int[] nums2,int k){
//        memo = new HashMap<>();
//        return solve(nums1,nums2,k,0,Integer.MAX_VALUE,0,0);
        int n = nums1.length;
        // Pair: (nums2, nums1)
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        // Sort by nums2 descending
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        // Min-heap for nums1 values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            sum += pairs[i][1];
            minHeap.offer(pairs[i][1]);

            // Keep only k elements
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // If we have exactly k elements, compute score
            if (minHeap.size() == k) {
                ans = Math.max(ans, sum * (long) pairs[i][0]);
            }
        }

        return ans;
    }

    private static long solve(int[] nums1, int[] nums2,int k,
                              int sum, int min,int i, int count) {
        if(count == k) return sum*min;
        if(i >= nums1.length) return 0;
        String key = i + ","+count+"," + sum +","+min;
        if(memo.containsKey(key)) return memo.get(key);
        long take = solve(nums1,nums2,k,sum+nums1[i],Math.min(min,nums2[i]),i+1,count+1);
        long skip = solve(nums1,nums2,k,sum,min,i+1,count);
        long ans =  Math.max(take,skip);
        memo.put(key,ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{4,2,3,1,1},new int[]{7,5,10,9,6},1));
    }
}
