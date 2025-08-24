package com.LeetCode.priorityQueue;

import java.util.PriorityQueue;

//https://leetcode.com/problems/total-cost-to-hire-k-workers/
public class TotalCost {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> leftHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int left = 0, right = n - 1;
        long ans = 0;

        // Fill initial candidates
        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(new int[]{costs[left], left});
            left++;
        }
        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(new int[]{costs[right], right});
            right--;
        }

        // Hire k workers
        for (int hire = 0; hire < k; hire++) {
            // Pick cheapest available
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek()[0] <= rightHeap.peek()[0])) {
                int[] chosen = leftHeap.poll();
                ans += chosen[0];
                if (left <= right) {
                    leftHeap.offer(new int[]{costs[left], left});
                    left++;
                }
            } else {
                int[] chosen = rightHeap.poll();
                ans += chosen[0];
                if (left <= right) {
                    rightHeap.offer(new int[]{costs[right], right});
                    right--;
                }
            }
        }
        return ans;
    }
}
